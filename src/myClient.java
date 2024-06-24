
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.io.File;


public class myClient 
{

 public static String fetch_index()
 {
     String url = "http://localhost:9000/";
     
     try
     {
     HttpResponse<String> res = Unirest.get(url).asString();
     
     if(res.getStatus() == 200)
     {
         return res.getBody();
     }
     
     else
     {
         return "server error";
     }
     
     }
     catch(Exception ex)
     {
         return ex.toString();
     }
     
 }
 public static String Login(String email, String pass)
 {
     String url = "http://localhost:9000/Login";
     try 
     {
     HttpResponse<String> res = Unirest.get(url)
             .queryString("email",email)
             .queryString("pass",pass)
             .asString();
     
     if(res.getStatus()==200)
     {
         return res.getBody();
     }
     else
     {
         return "error";
     }
             
             
             }
     catch(Exception ex)
     {
        return ex.toString();
     }
 }
 public static String Signup(String email, String pass, String mobile,String address,File ph)
 {
     String url ="http://localhost:9000/Signup";
     try
     {
     HttpResponse<String> res = Unirest.post(url)
     .queryString("email", email)
             .queryString("pass", pass)
             .queryString("mobile", mobile)
             .queryString("address",address)
             .field("ph",ph)
             .asString();
     
     if(res.getStatus()==200)
     {
         return res.getBody();
     }
     else
     {
         return "server error";
     }
     }
     catch(Exception ex)
     {
         return ex.toString();
     }
             
 }
 public static String fetchcat()
 {
     try
     {
     HttpResponse<String> res = Unirest.get("http://localhost:9000/fetchcat")
             .asString();
     if(res.getStatus()==200)
     {
         return res.getBody();
     }
     else
     {
         return "server error";
     }
     }
     catch(Exception ex)
     {
         return ex.toString();
     }
 }
 
 public static String courses(String category)
 {
     try
     {
         HttpResponse<String> res = Unirest.get("http://localhost:9000/courses")
                 .queryString("category", category)
                 .asString();
         
         if(res.getStatus()==200)
         {
             return res.getBody();
         }
         else
         {
             return "server error";
         }
     }
     catch(Exception ex)
     {
         return ex.toString();
     }
 }
 public static String fetchlectures(int course_id)
 {
    try
    {
        HttpResponse<String> res = Unirest.get("http://localhost:9000/fetchlectures")
                .queryString("course_id",course_id)
                .asString();
        
        if(res.getStatus()==200)
         {
             return res.getBody();
         }
         else
         {
             return "server error";
         }
        
        
    }
    catch(Exception ex)
    {
        return ex.toString();
    }
 }
 
public static String fetchdetails(int id)
{
    try
    {
        HttpResponse<String> res = Unirest.get("http://localhost:9000/fetchdetails")
                .queryString("id",id)
                .asString();
        
        if(res.getStatus()==200)
         {
             return res.getBody();
         }
         else
         {
             return "server error";
         }
        
        
    }
    catch(Exception ex)
    {
        return ex.toString();
    }
 }
 public static String adminLogin(String username, String password)
 {
     String url = "http://localhost:9000/adminLogin";
     try 
     {
     HttpResponse<String> res = Unirest.get(url)
             .queryString("username",username)
             .queryString("password",password)
             .asString();
     
     if(res.getStatus()==200)
     {
         return res.getBody();
     }
     else
     {
         return "error";
     }
             
             
             }
     catch(Exception ex)
     {
        return ex.toString();
     }
 }
 
 public static String addCategory(String category, File ph)
{
    try
    {
        HttpResponse<String> res = Unirest.post("http://localhost:9000/addcategory")
                .queryString("category",category)
                .field("f1", ph)
                .asString();
        
        if(res.getStatus()==200)
         {
             return res.getBody();
         }
         else
         {
             return "server error";
         }
        
        
    }
    catch(Exception ex)
    {
        return ex.toString();
    }
 }
 
 public static String fetchCat()
 {
    try
    {
        HttpResponse<String> res = Unirest.get("http://localhost:9000/fetchCat")
                
                .asString();
        
        if(res.getStatus()==200)
         {
             return res.getBody();
         }
         else
         {
             return "server error";
         }
        
        
    }
    catch(Exception ex)
    {
        return ex.toString();
    }
 }
 public static String deletecat(String name)
 {
    try
    {
        HttpResponse<String> res = Unirest.get("http://localhost:9000/deletecat")
                .queryString("name", name)
                
                .asString();
        
        if(res.getStatus()==200)
         {
             return res.getBody();
         }
         else
         {
             return "server error";
         }
        
        
    }
    catch(Exception ex)
    {
        return ex.toString();
    }
 }
 
 public static String fetchCategories()
 {
    try
    {
        HttpResponse<String> res = Unirest.get("http://localhost:9000/fetchCategories")
                
                .asString();
        
        if(res.getStatus()==200)
         {
             return res.getBody();
         }
         else
         {
             return "server error";
         }
        
        
    }
    catch(Exception ex)
    {
        return ex.toString();
    }
 }
 public static String addCourse(String category, File ph,String coursename , String coursedescription)
{
    try
    {
        HttpResponse<String> res = Unirest.post("http://localhost:9000/addCourse")
                .queryString("category",category)
                .queryString("coursename",coursename)
                .queryString("coursedescription",coursedescription)
                .field("ph", ph)
                .asString();
        
        if(res.getStatus()==200)
         {
             return res.getBody();
         }
         else
         {
             return "server error";
         }
        
        
    }
    catch(Exception ex)
    {
        return ex.toString();
    }
 }
 
 public static String fetchCourses(String Category)
 {
    try
    {
        HttpResponse<String> res = Unirest.get("http://localhost:9000/fetchCourses")
                .queryString("Category", Category)
                .asString();
        
        if(res.getStatus()==200)
         {
             return res.getBody();
         }
         else
         {
             return "server error";
         }
        
        
    }
    catch(Exception ex)
    {
        return ex.toString();
    }
 }
  public static String deleteCourse(int id)
 {
    try
    {
        HttpResponse<String> res = Unirest.get("http://localhost:9000/deleteCourse")
                .queryString("id", id)
                
                .asString();
        
        if(res.getStatus()==200)
         {
             return res.getBody();
         }
         else
         {
             return "server error";
         }
        
        
    }
    catch(Exception ex)
    {
        return ex.toString();
    }
 }
 public static String loadCourses()
 {
    try
    {
        HttpResponse<String> res = Unirest.get("http://localhost:9000/loadCourses")
                
                .asString();
        
        if(res.getStatus()==200)
         {
             return res.getBody();
         }
         else
         {
             return "server error";
         }
        
        
    }
    catch(Exception ex)
    {
        return ex.toString();
    }
 }
 public static String fetchhLectures(int course_id)
 {
     String url = "http://localhost:9000/fetchlectures1";
     
     try
     {
     HttpResponse<String> res = Unirest.get(url)
             .queryString("course_id", course_id)
             .asString();
     
     if(res.getStatus() == 200)
     {
         return res.getBody();
     }
     
     else
     {
         return "server error";
     }
     
     }
     catch(Exception ex)
     {
         return ex.toString();
     }
     
 }
  public static String deletelecture(int id)
 {
    try
    {
        HttpResponse<String> res = Unirest.get("http://localhost:9000/deletelecture")
                .queryString("id", id)
                
                .asString();
        
        if(res.getStatus()==200)
         {
             return res.getBody();
         }
         else
         {
             return "server error";
         }
        }
    catch(Exception ex)
    {
        return ex.toString();
    }
        
        
    }
  public static String addlecture(int course_id, File ph,String lecturename , String lecturedescription, String lectureduration,String lecturetrailer,File lecture)
{
    try
    {
        HttpResponse<String> res = Unirest.post("http://localhost:9000/addlecture")
                .queryString("course_id",course_id)
                .queryString("lecturename",lecturename)
                .queryString("lecturedescription",lecturedescription)
                .queryString("lectureduration",lectureduration)
                .queryString("lecturetrailer",lecturetrailer)
                .field("ph", ph)
                .field("lecture", lecture)
                .asString();
        
        if(res.getStatus()==200)
         {
             return res.getBody();
         }
         else
         {
             return "server error";
         }
        
        
    }
    catch(Exception ex)
    {
        return ex.toString();
    }
 }
}
  

