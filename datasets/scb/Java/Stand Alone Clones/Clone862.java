public class Clone862 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:24879212
*  Stack Overflow answer #:25283980
*  And Stack Overflow answer#:50288260
*/
public String GetFodlerSize () {
    String str = "";
    int Finalsize = 0;
    AWSCredentials credentials = new BasicAWSCredentials (accesskey, secretkey);
    AmazonS3 conn = new AmazonS3Client (credentials);
    ListObjectsRequest listObjectsRequest = new ListObjectsRequest ().withBucketName (BucketName).withPrefix (FolderName);
    ObjectListing objectListing;
    do {
        objectListing = conn.listObjects (listObjectsRequest);
        for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries ()) {
            str = (objectSummary.getSize () + "");
            int size = Integer.parseInt (str);
            Finalsize = Finalsize + size;
        }
        listObjectsRequest.setMarker (objectListing.getNextMarker ());
    } while (objectListing.isTruncated ());
    return FolderSize;
}

public void GetFodlerSize (Context context) {
    AmazonS3Client s3 = util.getS3Client (context);
    int Finalsize = 0;
    new AsyncTask < Void, Void, String > () {
        String str = "";
        int Finalsize = 0;
        @Override
        protected void onPreExecute () {
            dialog = ProgressDialog.show (context, "Loading", "wait");
        }@Override
        protected String doInBackground (Void...inputs) {
            ListObjectsRequest listObjectsRequest = new ListObjectsRequest ().withBucketName (Constants.BUCKET_NAME).withPrefix (NAME_OF_FOLDER_YOU_WANT_TO_GET_SIZE);
            ObjectListing objects = s3.listObjects (listObjectsRequest);
            for (S3ObjectSummary objectSummary : objects.getObjectSummaries ()) {
                str = (objectSummary.getSize () + "");
                int size = Integer.parseInt (str);
                Finalsize = Finalsize + size;
                objects = s3.listNextBatchOfObjects (objects);
            }
            String sizeString = null;
            if (Finalsize > 1024) {
                Finalsize = Finalsize / 1024;
                sizeString = " KB";
            }
            if (Finalsize > 1024) {
                Finalsize = Finalsize / 1024;
                sizeString = " MB";
            }
            if (Finalsize > 1024) {
                Finalsize = Finalsize / 1024;
                sizeString = " GB";
            }
            return "" + Finalsize + sizeString;
        }@Override
        protected void onPostExecute (String result) {
            dialog.dismiss ();
        }}
    .execute ();
}

}
