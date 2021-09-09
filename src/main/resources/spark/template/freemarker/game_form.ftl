<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="/styles/main.css">
</head>
<body>
<div class="content">
    <div class="paralax">
        <div class="layer rocks2"></div>
        <div class="layer rocks1"></div>
        <div class="layer hills"></div>
        <div class="layer foreground"></div>
    </div>
</div>
<div id="link">
    <!-- astea 2 sunt puse ca indexarea claselor sa inceapa de la 1 -->
    <div class="checker white_checker" style="display:none"> </div>
    <div class="checker black_checker" style="display:none"> </div>


    <div class="square" style="display: none" id ="ht"> </div>
    <div class="black_background" id="black_background"> </div>

    <div class="score" id="score">
        <br>
    </div>
    <div class="table" id="table">
        <!--TODO: Parse Board class into HTML-->
        <!--

        <div class="checker white_checker"> </div>
        <div class="checker white_checker"> </div>
        <div class="checker white_checker"> </div>
        <div class="checker white_checker"> </div>
        <div class="checker white_checker"> </div>
        <div class="checker white_checker"> </div>
        <div class="checker white_checker"> </div>
        <div class="checker white_checker"> </div>
        <div class="checker white_checker"> </div>
        <div class="checker white_checker"> </div>
        <div class="checker white_checker"> </div>
        <div class="checker white_checker"> </div>

        <div class="checker black_checker"> </div>
        <div class="checker black_checker"> </div>
        <div class="checker black_checker"> </div>
        <div class="checker black_checker"> </div>
        <div class="checker black_checker"> </div>
        <div class="checker black_checker"> </div>
        <div class="checker black_checker"> </div>
        <div class="checker black_checker"> </div>
        <div class="checker black_checker"> </div>
        <div class="checker black_checker"> </div>
        <div class="checker black_checker"> </div>
        <div class="checker black_checker"> </div>
-->

        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="clear_float"> </div>

        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="clear_float"> </div>

        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="clear_float"> </div>

        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="clear_float"> </div>

        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="clear_float"> </div>

        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="clear_float"> </div>

        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="clear_float"> </div>

        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="square white_square"> </div>
        <div class="square black_square"> </div>
        <div class="clear_float"> </div>

    </div>

    <audio id="moveSound">
        <source src = "sounds/move.mp3">
    </audio>
    <audio id="winSound">
        <<source src="sounds/win.mp3">
    </audio>
</div>
</div>
</body>
</html>
