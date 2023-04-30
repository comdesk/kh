<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>

    <style>
        *{
            margin: 0 auto;
            padding: 0;
        }
        table {
            border: 1px ridge purple;
            border-collapse: collapse;
        }
        th {
            padding: 10px;
            
            background-color: purple;
            color: white;
            font-size: 18px;
        }
        td {
            padding: 7px;
        }
        tr:hover {
            background-color: bisque;
        }
        a, a:link, a:visited {
            text-decoration: none;
        }
        #registerBtn {
            width: 150px;
            height: 40px;
            border: 0;
            margin-bottom: 20px;

            font-family: D2Coding;
            font-size: 18px;
            font-weight: bold;

            cursor: pointer;

            background-color: red;
            color: white;            
        }
    </style>
</head>

<body>
    <h1><%= request.getRequestURI() %></h1>
    <hr>

    <p>&nbsp;</p>
    <p>&nbsp;</p>

    <div id="wrapper">
        <table border="1">
            <caption>
                <button type="button" id="registerBtn">REGISTER</button>
            </caption>
            <thead>
                <tr>
                    <th>bno</th>
                    <th>title</th>
                    <!-- <th>content</th> -->
                    <th>writer</th>
                    <th>insert_ts</th>
                    <th>update_ts</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${list}" var="boardVO">
                    <tr>
                        <td>${boardVO.bno}</td>
                        <td><a href="/board/get?currPage=${param.currPage}&amount=${param.amount}&bno=${boardVO.bno}">${boardVO.title}</a></td>
                        <!-- <td>${boardVO.content}</td> -->
                        <td>${boardVO.writer}</td>
                        <td><fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${boardVO.insert_ts}" /></td>
                        <td>${boardVO.update_ts}</td>
                    </tr>
                </c:forEach>
                
            </tbody>

            <tfoot></tfoot>
        </table>
    </div>

    <script>
        var registerBtn = document.querySelector('#registerBtn');

        registerBtn.addEventListener('click', function () {
            location = '/board/register?currPage=${param.currPage}&amount=${param.amount}';
        }); //.addEventListener

        var result = "${param.result}";
        if(result != null && result != "") {
            alert('result: ' + result);
        }
        
    </script>
</body>

</html>