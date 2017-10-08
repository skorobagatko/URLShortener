<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <title>URL Shortener</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="url shortener" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" media="all" />
    <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
    <!--fonts-->
    <link href="http://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&subset=latin-ext" rel="stylesheet">
    <!--/fonts-->
</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="myCanvas"></canvas>
            <div class="main-title">
                <h1>Let's shorten this url!</h1>
                <div class="demo2"></div>

                <div class="url-shortener">
                    <%--<h2>Be the first to Know when website is ready</h2>--%>
                    <form action="${pageContext.request.contextPath}/" method="post">
                        <input type="url" name="url" required="true" placeholder="http://" />
                        <input type="submit" value="Get short" />
                        <div class="clear"></div>
                    </form>

                    <div class="shortened-url">
                        <h2>${shortUrl}</h2>
                        <%--<h2>${message}</h2>--%>
                    </div>
                </div>
                <footer>
                    <p class="agileinfo txt-center"> &copy; 2016 Awesome Coming soon Widget. All Rights Reserved | Design by  <a href="http://w3layouts.com/"> W3layouts</a></p>
                </footer>
            </div>
        </div>
    </div>
</div>
<!-- particles effect -->
<script src="<c:url value="/resources/js/particles.min.js" />"></script>
<script>
    window.onload = function() {
        Particles.init({
            selector: '#myCanvas',
            color: '#6a446b',
            connectParticles: true,
            minDistance: 70
        });
    };
</script>
<!-- //particles effect -->
</body>
</html>