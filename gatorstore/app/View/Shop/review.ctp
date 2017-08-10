<?php echo $this->set('title_for_layout', 'Order Review'); ?>
<?php echo $this->set('title_for_layout', 'Order Review'); ?>

<?php $this->Html->addCrumb('Order Review'); ?>

<?php echo $this->Html->script(array('jquery.validate.js', 'additional-methods.js', 'shop_review.js'), array('inline' => false)); ?>
<?php echo $this->Html->script(array('shop_address.js'), array('inline' => false)); ?>


<h1>Review And Place Your Order</h1>

<?php echo $this->Form->create('Order'); ?>

<hr>

<div class="row">

<div class="row">
    <div class="col col-sm-1">#</div>
    <div class="col col-sm-6">ITEM</div>
    <div class="col col-sm-1">WEIGHT</div>
    <div class="col col-sm-1">WEIGHT</div>
    <div class="col col-sm-1">PRICE</div>
    <div class="col col-sm-1" style="text-align: right;">QUANTITY</div>
    <div class="col col-sm-1" style="text-align: right;">SUBTOTAL</div>
</div>

<br />
<br />

<?php foreach ($shop['OrderItem'] as $item): ?>
<div class="row">
    <div class="col col-sm-1"><?php echo $this->Html->image('/images/small/' . $item['Product']['image'], array('height' => 60, 'class' => 'px60')); ?></div>
    <div class="col col-sm-6">
    <?php echo $item['Product']['name']; ?>
    <?php if(isset($item['Product']['productmod_name'])) : ?>
    <br />
    <small><?php echo $item['Product']['productmod_name']; ?></small>
    <?php endif; ?>
    </div>
    <div class="col col-sm-1"><?php echo $item['Product']['weight']; ?></div>
    <div class="col col-sm-1"><?php echo $item['totalweight']; ?></div>
    <div class="col col-sm-1">$<?php echo $item['Product']['price']; ?></div>
    <div class="col col-sm-1" style="text-align: right;"><?php echo $item['quantity']; ?></div>
    <div class="col col-sm-1" style="text-align: right;">$<?php echo $item['subtotal']; ?></div>
</div>
<?php endforeach; ?>

<hr>

<div class="row">
    <div class="col col-sm-10">Products: <?php echo $shop['Order']['order_item_count']; ?></div>
    <div class="col col-sm-1" style="text-align: right;">Items: <?php echo $shop['Order']['quantity']; ?></div>
    <div class="col col-sm-1" style="text-align: right;">Total<br /><strong>$<?php echo $shop['Order']['total']; ?></strong></div>
</div>

<hr>

<br />
<br />
        <?php echo $this->Form->input('first_name', array('class' => 'form-control')); ?>
        <br />
        <?php echo $this->Form->input('email', array('class' => 'form-control')); ?>
        <br />
        <?php echo $this->Form->input('phone', array('class' => 'form-control')); ?>
        <br />
	<?php echo $this->Form->input('last_name', array('label' => 'Message To Seller', 'class' => 'form-control', 'type' => 'textarea')); ?>
	
<br />
<br />
<br />


<?php echo $this->Form->button('<i class="fa fa-check"></i> &nbsp; Place your order', array('class' => 'btn btn-sm btn-success', 'ecape' => false)); ?>

<?php echo $this->Form->end(); ?>

<br />
<br />
