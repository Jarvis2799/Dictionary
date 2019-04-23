package com.example.dictionary;

import android.os.AsyncTask;

public class DictionaryRequest extends AsyncTask<String, Integer, String>
{

    final String app_id= "24d76429";
    final String app_key="10d95d73a520a5d04299dda5bd96b6b3";

    @Override
    protected String doInBackground(String... params)
    {
        try {
            URL url = new URL(params[0]);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept","application/json");
            urlConnection.setRequestProperty("app_id",app_id);
            urlConnection.setRequestProperty("app_key",app_key);

            // read the output from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();

        }
        catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
    }
}
