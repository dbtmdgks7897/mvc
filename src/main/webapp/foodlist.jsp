<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.mvc.dto.TbFoodDto" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="header.jsp" %>
<%
    List<TbFoodDto> list = (ArrayList<TbFoodDto>)request.getAttribute("foodlist");
%>
<div id="what-the-hell-is-this">
    <div class="page-title">
        <h2>입력된 음식 리스트</h2>
        <% if(userName != null){ %>
        <div align="left">
            <button type="button" class="btn btn-primary" id="myBtn">메뉴 추가</button>
        </div>
        <% } %>
        <table class="table table-dark table-hover">
            <thead>
            <tr>
                <th>음식이름</th>
                <th>이미지링크</th>
            </tr>
            </thead>
            <tbody>
            <% for(TbFoodDto d : list) { %>
            <tr>
                <td><%=d.getName()%></td>
                <td><%=d.getImg()%></td>
            </tr>
            <% } %>

            </tbody>
        </table>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title" style="color: black;">메뉴 추가</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="/action_page.php">
                    <div class="form-group">
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="menu" placeholder="메뉴명 입력" name="menu">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="img" placeholder="이미지 주소" name="img">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary" id="addBtn">추가</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>
</div>
<script>
    $(document).ready(function(){
        $("#myBtn").click(function(){
            $("#myModal").modal();
        });
        $("#addBtn").click(function (){
            var menu = $("#menu").val();
            var img = $("#img").val();
            $.post("addlist.gg",
                {
                    menu: menu,
                    img: img
                },
                function(data, status){
                    if(data == 1){
                        alert("메뉴 추가 성공");
                    }else {
                        alert("메뉴 추가 실패");
                    }
                    location.reload();
                });
        })
    });
</script>
</body>
</html>