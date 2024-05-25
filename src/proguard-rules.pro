# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.bextdev.headsetaudioonly.HeadsetAudioOnly {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/bextdev/headsetaudioonly/repack'
-flattenpackagehierarchy
-dontpreverify
