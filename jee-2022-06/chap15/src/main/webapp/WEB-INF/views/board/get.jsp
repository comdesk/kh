<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>상세게시글조회</title>
    
    <style>
        #wrapper {
            margin: 0 auto;

            font-family: D2Coding;
            font-size: 18px;
        }
    </style>

</head>

<body>
    <h1><%= request.getRequestURI() %></h1>
    <hr>

    <p>&nbsp;</p>
    <p>&nbsp;</p>

    <div id="wrapper">
        <form action="#">
            <table>
                <caption></caption>
                <thead></thead>
                <tbody>
                    <tr>
                        <td>BNO</td>
                        <td>${board.bno}</td>
                    </tr>
                    <tr>
                        <td>TITLE</td>
                        <td>${board.title}</td>
                    </tr>
                    <tr>
                        <td>CONTENT</td>
                        <td>${board.content}</td>
                    </tr>
                    <tr>
                        <td>WRITER</td>
                        <td>${board.writer}</td>
                    </tr>
                </tbody>
                <tfoot></tfoot>
            </table>

            <!-- <input type="button" value="MODIFY"> -->
            <button type="button" id="listBtn">LIST</button>
            <button type="button" id="modifyBtn">MODIFY</button>

        </form>
    </div>

    <script>
        var listBtn = document.querySelector('#listBtn');
        var modifyBtn = document.querySelector("#modifyBtn");

        // listBtn.onclick = function () {
        //     console.log('listBtn clicked...');
        // } //.onclick
        
        listBtn.addEventListener('click', function () {
        	location.href='/board/list?currPage=${param.currPage}&amount=${param.amount}';
        }) //.addEvenetLister

        modifyBtn.addEventListener('click', function () {
            window.location = "/board/modify?currPage=${param.currPage}&amount=${param.amount}&bno=${board.bno}";
        })
    </script>
</body>

</html>



