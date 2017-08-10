<?= $this->Html->css('custom.css') ?>
<?= $this->Html->script('custom.js') ?>

<?php $this->start('title'); ?>
About us
<?php $this->end(); ?>
<!-- Page Content -->
   <div class="container">
   <!-- Introduction Row -->
              <div class="row">
                  <div class="col-lg-12">
                      <h2 class="page-header">About Us
                          <small>It's Nice to Meet You!</small>
                      </h2>
                      <p>We are the <strong>team 9 </strong> from the class <strong>CSC 648(Spring 2017,Sec 02)</strong>.</p>
                  </div>
              </div>

           <!-- Team Members Row -->

               <div class="col-lg-12">
                   <h2 class="page-header">Our Team</h2>
               </div>

               <!-- MEMBERS -->
               <!-- Charles -->
               <div class="col-lg-4 col-sm-6 text-center">
                   <img class="img-circle img-responsive img-center" src="<?php echo $this->request->webroot; ?>img/charles.jpg">
                   <h2><?php echo $this->Html->link('Charles Williams', array('controller'=>'pages', 'action'=>'charlesaboutme', 'full_base'=>true)); ?>
                       <br><small>CEO</small>
                   </h2>
               </div>

               <!-- Jason -->
               <div class="col-lg-4 col-sm-6 text-center">
                   <img class="img-circle img-responsive img-center" src="<?php echo $this->request->webroot; ?>img/jason.jpg">
                   <h2><?php echo $this->Html->link('Jason Huang', array('controller'=>'pages', 'action'=>'jasonaboutme', 'full_base'=>true)); ?>
                       <br><small>CTO</small>
                   </h2>
               </div>

               <!-- Wilson -->
                  <div class="col-lg-4 col-sm-6 text-center">
                      <img class="img-circle img-responsive img-center" src="<?php echo $this->request->webroot; ?>img/wilson.jpg">
                      <h2><?php echo $this->Html->link('Wilson Le', array('controller'=>'pages', 'action'=>'wilsonaboutme', 'full_base'=>true)); ?>
                          <br><small>Front-End Developer</small>
                      </h2>
                  </div>

               <!-- Myat -->
                  <div class="col-lg-4 col-sm-6 text-center">
                      <img class="img-circle img-responsive img-center" src="<?php echo $this->request->webroot; ?>img/myat.jpg" alt="">
                      <h2><?php echo $this->Html->link('Myat Min Maung', array('controller'=>'pages', 'action'=>'myataboutme', 'full_base'=>true)); ?>
                          <br><small>Front-End Developer</small>
                      </h2>
                  </div>

               <!-- Grant -->
                  <div class="col-lg-4 col-sm-6 text-center">
                      <img class="img-circle img-responsive img-center" src="<?php echo $this->request->webroot; ?>img/grant.jpg" alt="">
                      <h2><?php echo $this->Html->link('Grant Gaviglio', array('controller'=>'pages', 'action'=>'grantaboutme', 'full_base'=>true)); ?>
                          <br><small>Front-End Developer</small>
                      </h2>
                  </div>

               <!-- Leopoldo -->
                  <div class="col-lg-4 col-sm-6 text-center">
                      <img class="img-circle img-responsive img-center" src="<?php echo $this->request->webroot; ?>img/leo.jpg" alt="">
                      <h2><?php echo $this->Html->link('Leopoldo Rodriguez', array('controller'=>'pages', 'action'=>'leopoldoaboutme', 'full_base'=>true)); ?>
                          <br><small>Back-End Developer</small>
                      </h2>
                  </div>
               </a>
               <div class="col-lg-4 col-sm-6 text-center">

               </div>

               <!-- Krishnan -->
                  <div class="col-lg-4 col-sm-6 text-center">
                      <img class="img-circle img-responsive img-center" src="<?php echo $this->request->webroot; ?>img/krishnan.jpg" alt="">
                      <h2><?php echo $this->Html->link('Krishnan Ramakrishnan', array('controller'=>'pages', 'action'=>'krishnanaboutme', 'full_base'=>true)); ?>
                          <small>Back-End Developer</small>
                      </h2>
                  </div>
               </a>
   </div>

