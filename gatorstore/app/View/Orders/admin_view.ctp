<h2>Order</h2>

<table class="table-striped table-bordered table-condensed table-hover">

    <tr>
        <td>Order ID</td>
        <td><?php echo h($order['Order']['id']); ?></td>
    </tr>

    <tr>
        <td>Name</td>
        <td><?php echo h($order['Order']['first_name']); ?></td>
    </tr>
   <tr>
        <td>eMail</td>
        <td><?php echo h($order['Order']['email']); ?></td>
    </tr>
    <tr>
        <td>Phone Number</td>
        <td><?php echo h($order['Order']['phone']); ?></td>
    </tr>
 
   <tr>
        <td>Weight</td>
        <td><?php echo h($order['Order']['weight']); ?></td>
    </tr>
    <tr>
        <td>Order Item Count</td>
        <td><?php echo h($order['Order']['order_item_count']); ?></td>
    </tr>
    <tr>
        <td>Subtotal</td>
        <td><?php echo h($order['Order']['subtotal']); ?></td>
    </tr>
   <tr>
        <td>Total</td>
        <td><?php echo h($order['Order']['total']); ?></td>
    </tr>
   <tr>
        <td>Status</td>
        <td><?php echo h($order['Order']['status']); ?></td>
    </tr>
   <tr>
        <td>Created</td>
        <td><?php echo h($order['Order']['created']); ?></td>
    </tr>
    <tr>
        <td>Modified</td>
        <td><?php echo h($order['Order']['modified']); ?></td>
    </tr>

    <tr>
        <td>Message From Buyer</td>
        <td><?php echo h($order['Order']['last_name']); ?></td>
    </tr>

</table>

<br />

<h3>Actions</h3>

<?php echo $this->Html->link('Edit Order', array('action' => 'edit', $order['Order']['id']), array('class' => 'btn btn-default')); ?>

<br />
<br />

<?php echo $this->Form->postLink('Delete Order', array('action' => 'delete', $order['Order']['id']), array('class' => 'btn btn-default btn-danger'), __('Are you sure you want to delete # %s?', $order['Order']['id'])); ?>

<br />
<br />


<h3>Related Order Items</h3>

<?php if (!empty($order['OrderItem'])): ?>
<table class="table-striped table-bordered table-condensed table-hover">
    <tr>
        <th>Id</th>
        <th>Order Id</th>
        <th>Product Id</th>
        <th>Name</th>
        <th>Quantity</th>
        <th>Weight</th>
        <th>Price</th>
        <th>Subtotal</th>
        <th>Created</th>
        <th>Modified</th>
        <th>Actions</th>
    </tr>
    <?php foreach ($order['OrderItem'] as $orderItem): ?>
    <tr>
        <td><?php echo $orderItem['id']; ?></td>
        <td><?php echo $orderItem['order_id']; ?></td>
        <td><?php echo $orderItem['product_id']; ?></td>
        <td><?php echo $orderItem['name']; ?></td>
        <td><?php echo $orderItem['quantity']; ?></td>
        <td><?php echo $orderItem['weight']; ?></td>
        <td><?php echo $orderItem['price']; ?></td>
        <td><?php echo $orderItem['subtotal']; ?></td>
        <td><?php echo $orderItem['created']; ?></td>
        <td><?php echo $orderItem['modified']; ?></td>
        <td>
            <?php echo $this->Html->link('View', array('controller' => 'order_items', 'action' => 'view', $orderItem['id']), array('class' => 'btn btn-default btn-xs')); ?>
            <?php echo $this->Html->link('Edit', array('controller' => 'order_items', 'action' => 'edit', $orderItem['id']), array('class' => 'btn btn-default btn-xs')); ?>
            <?php echo $this->Form->postLink('Delete', array('controller' => 'order_items', 'action' => 'delete', $orderItem['id']), array('class' => 'btn btn-danger btn-xs'), __('Are you sure you want to delete # %s?', $orderItem['id'])); ?>
        </td>
    </tr>
    <?php endforeach; ?>
</table>
<?php endif; ?>
