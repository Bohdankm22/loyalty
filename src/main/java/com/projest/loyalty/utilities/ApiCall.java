package com.projest.loyalty.utilities;

import com.projest.loyalty.entity.User;
import com.projest.loyalty.entity.UserRole;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApiCall {
    public static List<User> getAllbyAPI(){
        List<User> foundByAPI = new ArrayList<>();
        try {

            URL url = new URL("https://boiling-brushlands-32663.herokuapp.com/api/user");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                JSONArray jsonArray = new JSONArray(output);
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    int id = (int)jsonObject1.get("id");
                    System.out.println("this obj id is " + id);

                    URL url1 = new URL("https://boiling-brushlands-32663.herokuapp.com/api/user/" + id);
                    HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
                    conn1.setRequestMethod("GET");
                    conn1.setRequestProperty("Accept", "application/json");

                    if (conn1.getResponseCode() != 200) {
                        throw new RuntimeException("Failed : HTTP error code : "
                                + conn1.getResponseCode());
                    }

                    BufferedReader br1 = new BufferedReader(new InputStreamReader(
                            (conn1.getInputStream())));

                    String oupu;

                    while ((oupu = br1.readLine()) != null) {
                        JSONObject jsonObject2 = new JSONObject(oupu);
                        String name = (String) jsonObject2.get("name");
                        System.out.println("this user name is " + name);
                        String surname = (String) jsonObject2.get("surname");
                        System.out.println("this user surname is " + surname);
                        String userRole = (String) jsonObject2.get("userRole");
                        System.out.println("this user role is " + userRole);

                        User user = new User();
                        user.setId((int)jsonObject1.get("id"));
                        user.setName(name);
                        user.setSurname(surname);
                        user.setUserRole(UserRole.getUserRole(userRole));
                        foundByAPI.add(user);
                    }
                }
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return foundByAPI;
    }
}
