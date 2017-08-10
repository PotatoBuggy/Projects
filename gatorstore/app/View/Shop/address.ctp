<?php echo $this->set('title_for_layout', 'Address'); ?>

<?php $this->Html->addCrumb('Address'); ?>

<?php echo $this->Html->script(array('shop_address.js'), array('inline' => false)); ?>

<h1>Address</h1>

<?php echo $this->Form->create('Order'); ?>

<hr>

<div class="row">
    <div class="col col-sm-4">

        <?php echo $this->Form->input('first_name', array('class' => 'form-control')); ?>
        <br />
        <?php echo $this->Form->input('email', array('class' => 'form-control')); ?>
        <br />
        <?php echo $this->Form->input('phone', array('class' => 'form-control')); ?>
        <br />
	    <?php echo $this->Form->input('last_name', array('label' => 'Message To Seller', 'class' => 'form-control', 'type' => 'textarea')); ?>
	
        <br />
		<?php echo $this->Form->button('<i class="fa fa-check"></i> &nbsp; Continue', array('class' => 'btn btn-sm btn-success'));?>
		<?php echo $this->Form->end(); ?>
    </div>

<br />



