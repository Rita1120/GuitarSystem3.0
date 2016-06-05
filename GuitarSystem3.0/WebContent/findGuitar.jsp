<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page import="guitar.Model.Type" %>
 <%@ page import="guitar.Model.Wood" %>
 <%@ page import="guitar.Model.Builder" %>
 <%@ page import="guitar.Model.Guitar" %>
 <%@ page import="guitar.Model.GuitarSpec" %>
 <%@ page import="guitar.IDao.GuitarIDao" %>
 <%@ page import="guitar.IDaoImpl.GuitarIDaoImpl" %>
 <%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery.js"></script>
<title>查询吉他</title>
</head>
<body>
<form action="searchGuitar" method="post">
<label>生产商：</label><select name="builder" id="builder" >
                                              <option></option>
                                              <% for(int  i = 0; i<Builder.values().length;i++){%>
                                              <option value="<%=Builder.values()[i]%>"><%=Builder.values()[i]%></option>
                                              <%} %>
                                           </select>
<label>型号：</label><select name="model" id="model" >
                                            <option></option>
                                            <option value="STRATOCASTOR">STRATOCASTOR</option>
                                            <option value="CJ">CJ</option>
	                                        <option value="YAMAHA">YAMAHA</option>
                                      </select>
<br><br>
<label>类型：</label><select name="type" id="type">
                                          <option></option>
                                           <% for(int  i = 0; i<Type.values().length;i++){%>
                                              <option value="<%=Type.values()[i]%>"><%=Type.values()[i]%></option>
                                              <%} %>
                                          </select>
<label>背板木：</label><select name="backWood" id="backWood" >
                                              <option></option>
                                                 <% for(int  i = 0; i<Wood.values().length;i++){%>
                                              <option value="<%=Wood.values()[i]%>"><%=Wood.values()[i]%></option>
                                              <%} %>
                                           </select>
<label>顶端木：</label><select name="topWood" id="topWood" >
                                               <option></option>
                                                <% for(int  i = 0; i<Wood.values().length;i++){%>
                                                <option value="<%=Wood.values()[i]%>"><%=Wood.values()[i]%></option>
                                                 <%} %>
                                          </select>
<br><br>
&nbsp;&nbsp;&nbsp;
<input type="submit" name="find" id="find"  value="查询">
&nbsp;&nbsp;&nbsp;
<input type="reset" name="reset" value="重置">
</form>
<br><br>
<table border="1" width="600px">
	    <thead>
	        <tr>
	            <th>编号</th>
	            <th>价格</th>
	            <th>制造商</th>
	            <th>型号</th>
	            <th>类型</th>
	            <th>背板木</th>
	            <th>顶端木</th>
	            <th>操作</th>
	        </tr>
	    </thead>
	    <tbody>
  <% 
   //从数据库里面取出所有吉他
    GuitarIDao g=new GuitarIDaoImpl();
	List<Guitar> guitars = g.findAll();
	for (int i = 0; i < guitars.size(); i++) {
  %>
		<tr>
     	<td><%=guitars.get(i).getSerialNumber()%></td>
		<td><%=guitars.get(i).getPrice()%></td>
		<td><%=guitars.get(i).getSpec().getBuilder()%></td>
		<td><%=guitars.get(i).getSpec().getModel()%></td>
		<td><%=guitars.get(i).getSpec().getType()%></td>
		<td><%=guitars.get(i).getSpec().getBackWood()%></td>
		<td><%=guitars.get(i).getSpec().getTopWood() %></td>
		<td><a href="deleteGuitar?serialNumber=<%=guitars.get(i).getSerialNumber()%>">删除</a></td>
		</tr>    

	<%}
%>

 </tbody>
</table>
<br>
<a href="addGuitar.jsp">添加吉他</a>
<script type="text/javascript">
//获取参数   
function getUrlParam(name){  
    //构造一个含有目标参数的正则表达式对象  
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");  
    //匹配目标参数  
    var r = window.location.search.substr(1).match(reg);  
    //返回参数值  
    if (r!=null) return unescape(r[2]);  
    return null;  
}
$(document).ready(function(){
	var msg=getUrlParam('msg');
	if(msg==1){
		alert("删除成功");
	}else if(msg==2){
		alert("删除失败");
	}
     else{	}
}); 
</script>
</body>

</html>