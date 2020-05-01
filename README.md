Java Consume REST API
========================

Description: Java Consume REST API (GET/POST/PUT/DELETE)

Imports

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
```

## Url Connection

:warning: _Need add **throws declaration** or surround with **try/catch**;_

```java
URL url = new URL(String);
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
```

Sets the general request property. If a property with the key already exists, overwrite its value with the new value. 

```java
conn.setRequestProperty("Accept", "application/json");
conn.setRequestProperty("Content-Type", "application/json");
conn.setRequestMethod("POST");
```

To enable Output (Request Body) setting: ``true``
:warning: _If your request requires a body, the default RequestMethod is POST;_

```java
conn.setDoOutput(true);
```

To enable Output (Response Body) setting: ``true``

```java
conn.setDoInput(true);
```

When a request requires a body it is necessary to use OutputStreamWriter to send the data.

```java
OutputStreamWriter output = new OutputStreamWriter(conn.getOutputStream());
output.write(resquestBody.toString());
output.flush();
```

Gets the status code from an HTTP response message. 

```java
conn.getResponseCode()
conn.getResponseMessage()
```

Output

> Status: 200 - OK

When a request receives a body (response Body), it is necessary to use the InputStreamReader to receive the data.

```java
InputStreamReader input = new InputStreamReader(conn.getInputStream());
BufferedReader br = new BufferedReader(input);
String line = null;
StringBuilder responseBody = new StringBuilder();
responseBody.append("responseBody:\n");
while ((line = br.readLine()) != null) {
	responseBody.append("\t" + line + "\n");
}
```

## Exceptions

* _MalformedURLException_
* _IOException_


## Some links for more in depth learning

* [JAVA PRINT](https://github.com/fefong/java_print);
* [JAVA SWITCH CASE](https://github.com/fefong/java_switch);
* [JAVA IF/ELSE](https://github.com/fefong/java_ifElse);
* [JAVA ARITHMETIC](https://github.com/fefong/java_calculator);
