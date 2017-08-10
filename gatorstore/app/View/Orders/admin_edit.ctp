<h2>Admin Edit Order</h2>

<div class="row">

    <div class="col col-lg-3">

        <?php echo $this->Form->create('Order'); ?>

        <?php echo $this->Form->input('id', array('class' => 'form-control')); ?>
        <?php echo $this->Form->input('first_name', array('class' => 'form-control')); ?>
        <?php echo $this->Form->input('email', array('class' => 'form-control')); ?>
        <?php echo $this->Form->input('phone', array('class' => 'form-control')); ?>
       <?php echo $this->Form->input('weight', array('class' => 'form-control')); ?>
        <?php echo $this->Form->input('order_item_count', array('class' => 'form-control')); ?>
        <?php echo $this->Form->input('subtotal', array('class' => 'form-control')); ?>
        <?php echo $this->Form->input('tax', array('class' => 'form-control')); ?>
        <?php echo $this->Form->input('shipping', array('class' => 'form-control')); ?>
        <?php echo $this->Form->input('total', array('class' => 'form-control')); ?>
        <?php echo $this->Form->input('order_type', array('class' => 'form-control')); ?>
        <?php echo $this->Form->input('authorization', array('class' => 'form-control')); ?>
        <?php echo $this->Form->input('transaction', array('class' => 'form-control')); ?>
        <?php echo $this->Form->input('status', array('class' => 'form-control')); ?>
        <br />
        <?php echo $this->Form->button('Submit', array('class' => 'btn btn-primary'));?>
        <?php echo $this->Form->end();?>

    </div>

</div>
