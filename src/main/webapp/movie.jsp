<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="header.jsp" />
    <div id="what-the-hell-is-this">
        <div class="page-title">
            <h2>My Service</h2>
            <div id="movieList"></div>
        </div>
    </div>
</div>
</body>
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        // var search = $('#searchSpan').text();
        // alert(search);
        $.getJSON("/MovieServlet", function(result){
            var html = '';
            $.each(result, function(i, field){
                console.log(field);
                html += `<div class="col-md-6 col-lg-4 mb-5">
                    <div class="portfolio-item mx-auto" data-bs-toggle="modal" data-bs-target="#portfolioModal\${i+1}">
                    <div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
                    <div class="portfolio-item-caption-content text-center text-white"><i class="fas fa-plus fa-3x"></i></div>
                </div>
                <img class="img-fluid rounded mx-auto d-block" src="\${field}" alt="movie_image_1" />
            </div>
            </div>`;
            });
            $("#movieList").html(html);
        });
    });
</script>
</html>