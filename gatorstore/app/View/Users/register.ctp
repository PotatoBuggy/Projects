<h2><?php echo "Welcome to Gator Store!"; ?></h2>
<br />
<div class="row">
    <div class="col-sm-4">
		<?php echo "Please fill in the fields to register"; ?>
        <?php echo $this->Form->create('User', array('name' => 'registrationForm','id' => 'registrationForm', 'onsubmit' => "return validate()"));?>
        <?php echo $this->Form->input('role', array('class' => 'form-control', 'value' => 'customer', 'type' => 'hidden')); ?>
        <br />
        <?php echo $this->Form->input('name', array('class' => 'form-control')); ?>
        <br />
        <?php echo $this->Form->input('username', array('label' => 'SFSU E-Mail', 'class' => 'form-control', 'id' => 'username')); ?>
        <br />
        <?php echo $this->Form->input('password', array('class' => 'form-control', 'id' => 'password')); ?>
		<br />
		
        <?php echo $this->Form->input('passwordConfirm', array('class' => 'form-control', 'id' => 'passwordConfirm', 'type' => 'password')); ?>
		<br />
        <?php echo $this->Form->input('active', array('type' => 'hidden', 'value' => '1')); ?>
        <br />
		<input type="checkbox" name="I accept the terms and conditions" required> <?php echo "I accept the "; ?> 
		<?php echo $this->Html->link('Terms and Conditions', array('controller' => 'pages', 'action' => 'terms')); ?>
		<br />
        <?php echo $this->Form->button('Submit', array('class' => 'btn btn-primary')); ?>
        <?php echo $this->Form->end(); ?>

		<script>
		function validate() {
		var x = document.getElementById("username").value;
		var y = x.match(/@mail.sfsu.edu/);
		if(!y) {
		alert("Input a valid SFSU email");
		return false;
		}
		var pass = document.getElementById("password").value;
		var passConfirm = document.getElementById("passwordConfirm").value;
		if(pass != passConfirm) {
		alert("Your two passwords do not match, please try again");
		return false;
		}

		}
		</script>
    </div>
</div>

