<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>게시글상세수정화면</title>
</head>

<body>
    <h1><%= request.getRequestURI() %></h1>
    <hr>

    <p>&nbsp;</p>

    <div id="wrapper">
        <form action="/board/register" method="POST">

            <input type="hidden" name="currPage" value="${param.currPage}">
            <input type="hidden" name="amount" value="${param.amount}">

            <table>
                <caption></caption>
                <thead></thead>
                <tbody>
                    <tr>
                        <td>TITLE</td>
                        <td><input type="text" name="title" size="70"></td>
                    </tr>
                    <tr>
                        <td>CONTENT</td>
                        <td><textarea name="content" cols="70" rows="10"></textarea></td>
                    </tr>
                    <tr>
                        <td>WRITER</td>
                        <td><input type="text" name="writer" value="Yoseph" readonly></td>
                    </tr>
                </tbody>
                <tfoot></tfoot>
            </table>

            <button type="submit" id="submitBtn">REGISTER</button>
            <button type="button" id="listBtn">LIST</button>         

        </form>
    </div>

    <script>
        var listBtn = document.querySelector('#listBtn');

        listBtn.addEventListener('click', function () {
        	location.href='/board/list?currPage=${param.currPage}&amount=${param.amount}';
        }); //.addEvenetLister
    </script>
</body>

</html>