# GroupWork ProjectReddit

@author Ratna, Anne and Grace


Reference and notes:

1) Thymeleaf format localdatetime/date/localdate
http://www.baeldung.com/dates-in-thymeleaf   
For "LocalDateTime" data type, th:text="${#temporals.format(localDateTime, 'dd-MM-yyyy HH:mm')}"           
doesn't no work for instant class(current time?).         
However, For "Date" data type, th:text="${#dates.format(standardDate, 'dd-MM-yyyy HH:mm')}" would always work.     
       
2) Examples: Spring MVC - Binding URL query parameters with @RequestParam
http://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/spring-mvc-request-param/ 

3) clickable url and open url in new window/tab          
<a th:text="${link.title}" th:href="@{|${link.url}|}" target="_blank"></a>
target="_blank" is for opening url in a new tab/window
th:href="@{|${link.url}| for underlining the link and make it clickable







