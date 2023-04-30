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
        #pagination {
            width: 70%;
            margin: 20px auto;

            font-size: 16px;
        }
        #pagination ul {
            float: right;
        }
        #pagination li {
            float: left;

            width: 40px;
            height: 30px;
            /* border: 1px dotted purple; */

            list-style: none;
            text-align: center;
            line-height: 30px;
            font-weight: bold;
            font-family: D2Coding;
            cursor: pointer;            
        }
        #pagination li:hover {
            font-size: 20px;
            background-color: aquamarine;
        }
        .prev, .next {
            width: 70px !important;

            color: white;
            background-color: blueviolet;
        }
        li.currPage {
            font-weight: bold;

            color: white !important;
            background-color: green;
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

        <div id="pagination">
            <form id="paginationForm">
                <ul>
                    <!-- 1. prev 표시 -->
                    <c:if test="${pageMaker.prev}">
                        <li class="prev">
                            <a  data-temp="${pageMaker.cri.setCurrPage(pageMaker.startPage - 1)}"
                                href="/board/list${pageMaker.cri.pagingUri}">Prev</a>
                        </li>
                    </c:if>

                    <!-- 3. 페이지번호목록 표시 -->
                    <c:forEach var="pageNum" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                        <li class="${param.currPage eq pageNum ? 'currPage' : ''}">
                            <a  data-temp="${pageMaker.cri.setCurrPage(pageNum)}"
                                href="/board/list${pageMaker.cri.pagingUri}">${pageNum}</a>
                        </li>
                    </c:forEach>

                    <!-- 2. next 표시 -->
                    <c:if test="${pageMaker.next}">
                        <li class="next">
                            <a  data-temp="${pageMaker.cri.setCurrPage(pageMaker.endPage + 1)}"
                                href="/board/list${pageMaker.cri.pagingUri}">Next</a>
                        </li>
                    </c:if>
                </ul>

                <!--  Pagination에서 Prev or Next 버튼을 클릭했을 때,
                자바스크립트로 우리가 직접 form 태그를 조작해서 전송하기 위해 필요한
                기준 전송 파라미터(Criteria를 위한 전송파라미터들) 
                <input type="hidden" name="currPage">
                <input type="hidden" name="amount">
                <input type="hidden" name="pagesPerPage">
                <input type="hidden" name="type">
                <input type="hidden" name="keyword"> -->
            </form>
        </div>
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

        // // var prevAndNext = document.querySelector('a.Prev, a.Next');
        // var prevAndNext = document.querySelectorAll('a.Prev, a.Next');
        // console.log('prevAndNext:', prevAndNext);

        // prevAndNext.addEventListener('click', function (e) {
        //     e.preventDefault();
        //     console.log('clicked...');
        // }) //.addEventListener
        
    </script>
</body>

</html>