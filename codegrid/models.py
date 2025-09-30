import torch
from torch import nn

import torchvision

import numpy as np
import pandas as pd

from config import W2V_VECTOR_DIM, SAMPLE_WIDTH, SAMPLE_HEIGHT

class ResidualBlock(nn.Module):
    def __init__(self, in_channels, out_channels, stride = 1, downsample = None):
        super(ResidualBlock, self).__init__()
        self.conv1 = nn.Sequential(
                        nn.Conv2d(in_channels, out_channels, kernel_size = 3, stride = stride, padding = 1),
                        nn.BatchNorm2d(out_channels),
                        nn.ReLU())
        self.conv2 = nn.Sequential(
                        nn.Conv2d(out_channels, out_channels, kernel_size = 3, stride = 1, padding = 1),
                        nn.BatchNorm2d(out_channels))
        self.downsample = downsample
        self.relu = nn.ReLU()
        self.out_channels = out_channels
        
    def forward(self, x):
        residual = x
        out = self.conv1(x)
        out = self.conv2(out)
        if self.downsample:
            residual = self.downsample(x)
        out += residual
        out = self.relu(out)
        return out

class ResNet(nn.Module):
    def __init__(self, block, layers, num_classes = 10):
        super(ResNet, self).__init__()
        self.inplanes = 64
        self.conv1 = nn.Sequential(
                        nn.Conv2d(3, 64, kernel_size = 7, stride = 2, padding = 3),
                        nn.BatchNorm2d(64),
                        nn.ReLU())
        self.maxpool = nn.MaxPool2d(kernel_size = 3, stride = 2, padding = 1)
        self.layer0 = self._make_layer(block, 64, layers[0], stride = 1)
        self.layer1 = self._make_layer(block, 128, layers[1], stride = 2)
        self.layer2 = self._make_layer(block, 256, layers[2], stride = 2)
        self.layer3 = self._make_layer(block, 512, layers[3], stride = 2)
        self.avgpool = nn.AvgPool2d(7, stride=1)
        self.fc = nn.Linear(512, num_classes)
        
    def _make_layer(self, block, planes, blocks, stride=1):
        downsample = None
        if stride != 1 or self.inplanes != planes:
            
            downsample = nn.Sequential(
                nn.Conv2d(self.inplanes, planes, kernel_size=1, stride=stride),
                nn.BatchNorm2d(planes),
            )
        layers = []
        layers.append(block(self.inplanes, planes, stride, downsample))
        self.inplanes = planes
        for i in range(1, blocks):
            layers.append(block(self.inplanes, planes))

        return nn.Sequential(*layers)
    
    
    def forward(self, x):
        x = self.conv1(x)
        x = self.maxpool(x)
        x = self.layer0(x)
        x = self.layer1(x)
        x = self.layer2(x)
        x = self.layer3(x)

        x = self.avgpool(x)
        x = x.view(x.size(0), -1)
        x = self.fc(x)

        return x

def CodeGridClassificationModel(in_channels, num_classes):
    # Load pre-trained ResNet with 50 layers
    model = torchvision.models.resnet50(weights='DEFAULT')

    # ResNet50 accepts inputs with 3 channels by default. If we want to feed it inputs with >3 channels, we replace the first layer with a new 
    # Conv2d layer with the desired number of input channels. 
    if in_channels > 3:
        weight = model.conv1.weight.clone() # resnet weights for 3 input channels

        # block = nn.Sequential(
        #             nn.Conv2d(in_channels, 64, kernel_size=7, stride=2, padding=1),
        #             nn.BatchNorm2d(64),
        #             nn.ReLU())

        model.conv1 =  nn.Conv2d(in_channels, 64, kernel_size=7, stride=2, padding=3, bias=False)

        # nn.Conv2d(in_channels, 64, kernel_size=7, stride=2, padding=3,bias=False)

        # Initialize the 3 first channels of the new layer with the ResNet pretrained weights. 
        # Initialize the 4th channel weights with the weights of the 1st pre-trained channel
        # The rest of the channels (5-N) remain randomly initialized
        with torch.no_grad():
            model.conv1.weight[:, :3] = weight
            model.conv1.weight[:, 3] = model.conv1.weight[:, 0]

            # model.fc = nn.Linear(10240, num_classes)
    return model
        

if __name__ == '__main__':
    device = torch.device("cuda" if torch.cuda.is_available() else "cpu")

    num_classes   = 10
    num_epochs    = 20
    batch_size    = 16
    learning_rate = 0.01

    model = CodeGridClassificationModel(W2V_VECTOR_DIM, num_classes=2)

    # # Loss and optimizer
    # criterion = nn.CrossEntropyLoss()
    # optimizer = torch.optim.SGD(model.parameters(), lr=learning_rate, weight_decay = 0.001, momentum = 0.9)

    X = np.random.rand(10, W2V_VECTOR_DIM, SAMPLE_WIDTH, SAMPLE_HEIGHT)
    print(X.shape)
    y = np.random.randint(0, 2, size=10)
    X = torch.from_numpy(X).float()
    y = torch.LongTensor(y)
    outputs = model(X)
    print(outputs)