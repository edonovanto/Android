package com.novanto.mybackgroundthread;

interface MyAsyncCallback {
    void onPreExecute();
    void onPostExecute(String text);
}
