<?php
App::uses('AppModel', 'Model');
class Order extends AppModel {

//////////////////////////////////////////////////

    public $validate = array(
        'name' => array(
            'rule1' => array(
                'rule' => array('notBlank'),
                'message' => 'Name is invalid',
            ),
        ),
        'email' => array(
            'rule1' => array(
                'rule' => array('email'),
                'message' => 'Email is invalid',
            ),
        ),
        'phone' => array(
            'rule1' => array(
                'rule' => array('phone'),
                'message' => 'Phone is invalid',
            ),
        ),
    );

//////////////////////////////////////////////////

    public $hasMany = array(
        'OrderItem' => array(
            'className' => 'OrderItem',
            'foreignKey' => 'order_id',
            'dependent' => true,
            'conditions' => '',
            'fields' => '',
            'order' => '',
            'limit' => '',
            'offset' => '',
            'exclusive' => '',
            'finderQuery' => '',
            'counterQuery' => '',
        )
    );

//////////////////////////////////////////////////

}
