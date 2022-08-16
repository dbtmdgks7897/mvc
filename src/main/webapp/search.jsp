<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="header.jsp" />
    <div id="what-the-hell-is-this">
        <div class="page-title">
            <h2>뉴스 검색</h2>
            <form action="/SearchServlet">
                <input type="text" name="search">
                <input type="submit" value="검색">
            </form>
            검색어 : <span id="searchSpan"></span><br/>
            <div id="searchData">
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>

</script>
</html>