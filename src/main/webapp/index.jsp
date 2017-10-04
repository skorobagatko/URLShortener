<!DOCTYPE html>
<html lang="en">
<head>
    <title>URL Shortener</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="url shortener" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" /><!-- stylesheet -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!--fonts-->
    <link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&subset=latin-ext" rel="stylesheet">
    <!--/fonts-->
</head>
<body>
<!-- main-section -->
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="myCanvas"></canvas>
            <div class="main-title">
                <h1>We are Coming Soon</h1>
                <div class="demo2"></div>

                <div class="url-shortener">
                    <h2>Be the first to Know when website is ready</h2>
                    <form action="#" method="post">
                        <input type="email" name="email" required="true" placeholder="URL" />
                        <input type="submit" value="Get short" />
                        <div class="clear"></div>
                    </form>
                </div>
                <footer>
                    <p class="agileinfo txt-center"> &copy; 2016 Awesome Coming soon Widget. All Rights Reserved | Design by  <a href="http://w3layouts.com/"> W3layouts</a></p>
                </footer>
            </div>
        </div>
    </div>
</div>
<!-- /main-section -->
<!-- particles effect -->
<script src="js/particles.min.js"></script>
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
<!-- //Body -->
</html>
<!-- //Html -->