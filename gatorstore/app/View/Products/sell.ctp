<?php $this->Html->addCrumb('Sell'); ?>



<div class="row">
    <div class="col-md-4">
        <h1><div style= margin:auto>Sell an Item</div></h1>
        <?php echo $this->Form->create('Product'); ?>
        <br />
        <?php echo $this->Form->input('category_id', array('class' => 'form-control')); ?>
        <br />
        <?php echo $this->Form->input('brand_id', array('class' => 'form-control', 'type' => 'hidden', 'value' => '1')); ?>
        <br />
        <?php echo $this->Form->input('name', array('class' => 'form-control')); ?>
        <br />
        <?php echo $this->Form->input('slug', array('class' => 'form-control',)); ?>
        <br />
        <?php echo $this->Form->input('description', array('class' => 'form-control')); ?>
        <br />
        <?php echo $this->Form->input('image', array('class' => 'form-control', 'type' => 'file')); ?>
        <br />
        <?php echo $this->Form->input('price', array('class' => 'form-control')); ?>
        <br />
        <?php echo $this->Form->input('weight', array('class' => 'form-control', 'type' => 'hidden', 'value' => '0.01')); ?>
        <br />
        <?php echo $this->Form->input('active', array('type' => 'checkbox', 'value' => '1', 'type' => 'hidden')); ?>
        <br />
        <?php echo $this->Form->button('Submit', array('class' => 'btn btn-primary')); ?>
        <?php echo $this->Form->end(); ?>
    </div>
</div>