<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JALSGAMES</title>
    
    <body BGCOLOR=003366>
         

        <center><font color="White"> 
    <script>
function usrpas(){
if (document.form1.txt.value=="alejandro" && document.form1.num.value=="1234"){window.location="listProducts.do"}
else {alert("Error en Usuario o Contrase&na. Intenta de nuevo.")}
}
document.oncontextmenu=new Function("return false");
</script>
<form name="form1">
<h1 align="center"><font size=48>JalsGames</h1> </font>
<p><center><font size=2>Ingrese su nombre de usuario y contrase&ntildea
               <p><center><font size=5>Nombre de usuario
               <p><center>  <input type="text" name="txt"><br>
               <p><center><font size=5>Contrase&ntildea
               <p><center><input type="text" name="num"> 
<p><center><input type="button" value="Ingresar" onclick="usrpas()">
</form>

    </body>
</html>