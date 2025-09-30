public class Clone498 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19827983
*  Stack Overflow answer #:19828243
*  And Stack Overflow answer#:19831774
*/
public void onActivityResult (int requestCode, int resultCode, Intent data) {
    super.onActivityResult (requestCode, resultCode, data);
    if (requestCode == CAMERA_RESULT) {
        if (resultCode == Activity.RESULT_OK) {
            String galleryImatePath = SD_CARD_TEMP_DIR;
            File f = new File (galleryImatePath);
            try {
                Bitmap cameraBitmap = null;
                BitmapFactory.Options bmOptions = new BitmapFactory.Options ();
                bmOptions.inJustDecodeBounds = false;
                bmOptions.inPurgeable = true;
                bmOptions.inBitmap = cameraBitmap;
                bmOptions.inMutable = true;
                cameraBitmap = BitmapFactory.decodeFile (galleryImatePath, bmOptions);
                ByteArrayOutputStream bos = new ByteArrayOutputStream ();
                cameraBitmap.compress (Bitmap.CompressFormat.JPEG, 50, bos);
                ExifInterface exif = new ExifInterface (galleryImatePath);
                float rotation = exif.getAttributeInt (ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
                System.out.println (rotation);
                float rotationInDegrees = exifToDegrees (rotation);
                System.out.println (rotationInDegrees);
                Matrix matrix = new Matrix ();
                matrix.postRotate (rotationInDegrees);
                final Bitmap rotatedBitmap = Bitmap.createBitmap (cameraBitmap, 0, 0, cameraBitmap.getWidth (), cameraBitmap.getHeight (), matrix, true);
                FileOutputStream fos = new FileOutputStream (galleryImatePath);
                rotatedBitmap.compress (Bitmap.CompressFormat.JPEG, 50, fos);
                fos.write (bos.toByteArray ());
                cameraBitmap.recycle ();
                System.gc ();
                fos.flush ();
                fos.close ();
                Capdialog = new Dialog (AddToDo.this, android.R.style.Theme_NoTitleBar_Fullscreen);
                Capdialog.setContentView (R.layout.captiondialog);
                Capdialog.setCancelable (false);
                TextView cancel = (TextView) Capdialog.findViewById (R.id.cancel);
                TextView done = (TextView) Capdialog.findViewById (R.id.done);
                Capdialog.getWindow ().setSoftInputMode (WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                ImageView img = (ImageView) Capdialog.findViewById (R.id.image);
                img.setImageBitmap (rotatedBitmap);
            } catch (Exception e) {
            }
        }
    }
}

protected void onActivityResult (int requestCode, int resultCode, Intent data) {
    super.onActivityResult (requestCode, resultCode, data);
    if (requestCode == 0) {
        try {
            Bitmap cameraBitmap;
            cameraBitmap = BitmapFactory.decodeFile (myFilesDir + "/temp.jpg");
            Bitmap.createBitmap (cameraBitmap);
            ivPhoto.setImageBitmap (cameraBitmap);
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}

}
