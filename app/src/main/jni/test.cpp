#include "jni.h"
#include "com_pjx_mvvmdemo_myjni_MyJni.h"
JNIEXPORT jstring JNICALL Java_com_pjx_mvvmdemo_myjni_MyJni_getString
  (JNIEnv *env, jclass jz){

 return env->NewStringUTF((char *)"Hello from JNI !");

  }