<!DOCTYPE html>
<html>
    <head>
        <title>
            Tip Calculator
        </title>
        <!-- Bootstrap Stuffs -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="BootstrapAssist.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            .navbar-inverse{
                background-color: #1B2631;
            }
        </style>
    </head>
    <body>
        <!-- Navigation Bar -->
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span> 
                    </button>
                    <a class="navbar-brand" href="newindex.html">MyatMinMaung</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav  navbar-nav nav-pills">
                        <li><a href="newindex.html">Home</a></li>
                        <li><a href="newabout.html">About Me</a></li>
                        <li class="active"><a href="Tcal.php">Tip Calculator</a></li> 
                    </ul>
                </div>
            </div>
        </nav>
        <br><br><br><br><br><br>

        <!-- Tip Calculator -->
        <div class="row">
            <div class="col-md-5" style="background-color: transparent;">
            </div>
            <!-- Calculator -->
            <div class="col-md-2" style="border-style: solid; border-width: medium; 
                 background-color: lightcoral; text-align: center; padding: 10px">
                <?php
                echo "Tip Calculator";
                ?>
                <form action="Tcal.php" method="post"> 
                    Bill Subtotal: 
                    $<input type="text" name="amount" value="<?php echo $_POST["amount"]; ?>" size="9" > <br><br> 

                    Tip percentages: <br>
                    <?php
                    $percentage = 10;
                    for ($i = 0; $i < 3; $i++, $percentage += 5) {
                        ?>
                        <input type="radio" name="value" value="<?php echo $percentage; ?>"
                               <?php if (isset($_POST["value"]) && $_POST["value"] == $percentage) echo 'checked="checked"'; ?>> 
                               <?php echo $percentage . "%"; ?>
                               <?php
                           }
                           ?>

                    <br><input type="radio" name="value" value="0" 
                               <?php if (isset($_POST["value"]) && $_POST["value"] == '0') echo 'checked= "checked"'; ?>> 
                    Custom: 
                    <input type="text" name="percent" value="<?php echo $_POST["percent"]; ?>"  size="8">%
                    <?php
                    $percentage = $_POST[percent];
                    ?>
                    <br>
                    <br> Split: <input type="text" name="people" value="<?php echo $_POST["people"]; ?>" size="7"> person(s).

                    <br><input type="submit" value="Submit"> <br><br>
                    <?php
                    $charge = $_POST["amount"];
                    $tip = $_POST["value"] ? $_POST["value"] : $_POST["percent"];

                    if (!isset($_POST["people"])) {
                        $person = 1;
                    } else {
                        $person = $_POST["people"];
                    }
                    $tipResult = 0;
                    $total = 0;

                    if ($charge >= 0) {
                        $tipResult = ($tip / 100) * $charge;
                        $total = $charge + $tipResult;
                    }

                    if ($total > 0) {
                        echo "Tip: $" . number_format($tipResult, 2, '.', ' ') . "<br>" . "Total: $" . number_format($total, 2, '.', ' ') . "<br>";
                    }

                    if ($person > 1) {
                        $tipResult /= $person;
                        $total /= $person;

                        echo "Tip each: $" . number_format($tipResult, 2, '.', ' ') . "<br>" . "Total each: $" . number_format($total, 2, '.', ' ');
                    }
                    ?>
                </form>
            </div>
            <div class="col-md-4" style="background-color: transparent;">
            </div>
        </div>
        <br>
        
        <!-- Git -->
        <div class="centeredBody" style="background-color: transparent; border-style: none;">
            <!-- Github -->
            <a href="https://github.com/PotatoBuggy">
                <img id="Gi" src="http://cdn.mysitemyway.com/icons-watermarks/flat-rounded-square-white-on-black/foundation/foundation_social-github/foundation_social-github_flat-rounded-square-white-on-black_512x512.png"
                     alt="github" width="55">
            </a>
        </div>
    </div> 
</body>
</html>
