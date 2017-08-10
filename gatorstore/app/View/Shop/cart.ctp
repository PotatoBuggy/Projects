<?php echo $this->set('title_for_layout', 'Order Total'); ?>

<?php $this->Html->addCrumb('Order'); ?>

<?php echo $this->Html->script(array('cart.js'), array('inline' => false)); ?>

<h1>Order Total</h1>

<?php if(empty($shop['OrderItem'])) : ?>

Shopping Cart is empty

<?php else: ?>

<?php echo $this->Form->create(NULL, array('url' => array('controller' => 'shop', 'action' => 'cartupdate'))); ?>

<hr>

<!--<div class="row">-->
<!--<div class="col col-sm-1">#</div>-->
<!--<div class="col col-sm-9">ITEM</div>-->
<!--<div class="col col-sm-1">PRICE</div>-->
<!--</div>-->

<?php $tabindex = 1; ?>
<?php foreach ($shop['OrderItem'] as $key => $item): ?>

<div class="row" id="row-<?php echo $key; ?>">
    <div class="col col-sm-9">
        <strong><?php echo $this->Html->link($item['Product']['name'], array('controller' => 'products', 'action' => 'view', 'slug' => $item['Product']['slug'])); ?></strong>
        <?php
            $mods = 0;
            if(isset($item['Product']['productmod_name'])) :
            $mods = $item['Product']['productmod_id'];
            ?>
        <br />
        <small><?php echo $item['Product']['productmod_name']; ?></small>
        <?php endif; ?>
    </div>
    <br />
    <div class="col col-sm-1"><?php echo $this->Html->image('/images/small/' . $item['Product']['image'], array('class' => 'px60')); ?></div>
    <!--<div class="col col-sm-1" id="price-<?php echo $key; ?>"><?php echo $item['Product']['price']; ?></div>-->
</div>
<?php endforeach; ?>

<hr>

<?php echo $this->Form->end(); ?>



<div class="row">
    <div class="col col-sm-12 pull-right tr">
        Order Total: <span class="red" id="total">$<?php echo $shop['Order']['total']; ?></span>
        <br />
    </div>
</div>

<div class="row">
    <div class="col col-sm-12">
 <?php echo $this->Html->link('<i class="fa fa-check"></i> &nbsp; Checkout', array('controller' => 'shop', 'action' => 'review'), array('class' => 'btn btn-sm btn-success', 'escape' => false)); ?>

 <?php echo $this->Form->create(NULL, array('url' => array('controller' => 'shop', 'action' => 'step1'))); ?>
       Message Seller
        <br />
        <?php echo $this->Form->create('Product', array()); ?>
       <?php echo $this->Form->end(); ?>
    </div>
</div>

<br />
<br />

<?php endif; ?>
