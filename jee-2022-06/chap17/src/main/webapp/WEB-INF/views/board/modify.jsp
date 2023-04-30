<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>신규게시글작성</title>
</head>

<body>
    <h1><%= request.getRequestURI() %></h1>
    <hr>

    <p>&nbsp;</p>
    <p>&nbsp;</p>

    <div id="wrapper">
        <form action="/board/modify" method="POST">

            <input type="hidden" name="currPage" value="${param.currPage}">
            <input type="hidden" name="amount" value="${param.amount}">

            <table>
                <caption></caption>
                <thead></thead>
                <tbody>
                    <tr>
                        <td>BNO</td>
                        <td><input type="text" name="bno" value="${board.bno}" readonly></td>
                    </tr>
                    <tr>
                        <td>TITLE</td>
                        <td><input type="text" name="title" value="${board.title}" size="70"></td>
                    </tr>
                    <tr>
                        <td>CONTENT</td>
                        <td><textarea name="content" cols="70" rows="10">${board.content}</textarea></td>
                    </tr>
                    <tr>
                        <td>WRITER</td>
                        <td><input type="text" name="writer" value="${board.writer}" readonly></td>
                    </tr>
                </tbody>
                <tfoot></tfoot>
            </table>

            <button type="submit" id="submitBtn">MODIFY</button>
            <button type="button" id="removeBtn">REMOVE</button>
            <button type="button" id="listBtn">LIST</button>
            

        </form>
    </div>

    <script>
        var listBtn = document.querySelector('#listBtn');
        var removeBtn = document.querySelector("#removeBtn");

        // listBtn.onclick = function () {
        //     console.log('listBtn clicked...');
        // }; //.onclick
        
        listBtn.addEventListener('click', function () {
        	location.href='/board/list?currPage=${param.currPage}&amount=${param.amount}';
        }); //.addEvenetLister

        removeBtn.addEventListener('click', function () {
            //Form 태그를 조작해서, 삭제 요청을 전송
            var form = document.querySelector('form');
            // console.log(form.constructor.prototype);

            form.setAttribute('method', 'POST');
            form.setAttribute('action', '/board/remove');
            form.submit();

        }); //.addEvenetLister
    </script>

</body>

</html>