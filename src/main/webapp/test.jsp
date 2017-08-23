<link rel="stylesheet" type="text/css" href="css/css.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.min.css" />
<script src="js/jq/jquery.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>

<div class="alert alert-primary" role="alert">
    This is a primary alert—check it out!
</div>
<style>
    .hide{
        display:none;
    }
    .show{
        display:block;
    }
</style>

<div class="testbox" >
    <ul>
        <li><a href="#">我是链接1</a></li>
        <li><a href="#">我是链接2</a></li>
        <li><a href="#">我是链接3</a></li>
        <li><a href="#">我是链接4</a></li>
        <li><a href="#" >我是链接5</a></li>
        <li><a href="#" class="hide">我是链接6</a></li>
        <li><a href="#" class="hide">我是链接7</a></li>
        <li><a href="#" class="hide">我是链接8</a></li>
        <li><a href="#" class="hide">我是链接9</a></li>
        <li><a href="#" class="hide">我是链接10</a></li>
    </ul>
    <button id="show">点击展开</button>
</div>
<script>
    $("#show").on('click',function(){
        $(".testbox>ul>li").each(function(){
            if($(this).find("a").attr("class") == "hide"){
                $(this).find("a").removeClass("hide").addClass("show");
            }else if($(this).find("a").attr("class") == "show"){
                $(this).find("a").removeClass("show").addClass("hide");
            }
        });
    });
</script>.