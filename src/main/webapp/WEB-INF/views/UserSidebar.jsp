<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

      <li class="nav-item">
        <a class="nav-link " href="home">
          <i class="bi bi-grid"></i>
          <span>User Dashboard</span>
        </a>
      </li><!-- End Dashboard Nav -->


      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#7-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-list"></i><span>States</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="7-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="liststate">
              <i class="bi bi-circle"></i><span>List State</span>
            </a>
          </li>
                    
        </ul>
      </li><!-- End States Nav -->
      
      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#8-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-joystick"></i><span>Cities</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="8-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="listcity">
              <i class="bi bi-circle"></i><span>List City</span>
            </a>
          </li>
                    
        </ul>
      </li><!-- End Cities Nav -->

   
      <li class="nav-item"><!-- i have used #tables-nav -->
        <a class="nav-link collapsed" data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-opencollective"></i><span>Orders</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="tables-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="listorder">
              <i class="bi bi-circle"></i><span>List Orders</span>
            </a>
          </li>
          <li>
            <a href="listorderdetail">
              <i class="bi bi-circle"></i><span>List Orders Detail</span>
            </a>
          </li>
        </ul>
      </li><!-- End Orders Nav -->
      
      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#4-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-cart"></i><span>Cart</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="4-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="cart">
              <i class="bi bi-circle"></i><span>Add Cart</span>
            </a>
          </li>
          <li>
            <a href="listcart">
              <i class="bi bi-circle"></i><span>List Cart</span>
            </a>
          </li>
        </ul>
      </li><!-- End Orders Nav -->
      

      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#5-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-bar-chart"></i><span>Category</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="5-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
           <li>
            <a href="category">
              <i class="bi bi-circle"></i><span>Add Category</span>
            </a>
          </li>
          <li>
            <a href="listcategory">
              <i class="bi bi-circle"></i><span>List Category</span>
            </a>
          </li>
        </ul>
      </li><!-- End Category Nav -->
      
      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#2-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-bar-chart-steps"></i><span>Sub Category</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="2-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="subcategory">
              <i class="bi bi-circle"></i><span>Add Sub Category</span>
            </a>
          </li>
          <li>
            <a href="listsubcategory">
              <i class="bi bi-circle"></i><span>List Sub Category</span>
            </a>
          </li>
        </ul>
      </li><!-- End Sub Category Nav -->
      
      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#3-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-bag"></i><span>Products</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="3-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="newproduct">
              <i class="bi bi-circle"></i><span>Add Products</span>
            </a>
          </li>
          <li>
            <a href="listproduct">
              <i class="bi bi-circle"></i><span>List Products</span>
            </a>
          </li>
        </ul>
      </li><!-- End Products Nav -->
      
      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#1-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-book"></i><span>Reviews</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="1-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="newreviews">
              <i class="bi bi-circle"></i><span>Add Reviews</span>
            </a>
          </li>
          <li>
            <a href="listreviews">
              <i class="bi bi-circle"></i><span>List Reviews</span>
            </a>
          </li>
        </ul>
      </li><!-- End Reviews Nav -->
      
      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#6-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-heart-fill"></i><span>Wishlist</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="6-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="newwishlist">
              <i class="bi bi-circle"></i><span>Create Wishlists</span>
            </a>
          </li>
          <li>
            <a href="listwishlist">
              <i class="bi bi-circle"></i><span>List Wishlists</span>
            </a>
          </li>
        </ul>
      </li><!-- End Wishlists Nav -->

      

      <li class="nav-heading">Manage</li>

      <li class="nav-item">
        <a class="nav-link collapsed" href="users-profile.html">
          <i class="bi bi-person"></i>
          <span>Profile</span>
        </a>
      </li><!-- End Profile Page Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" href="pages-faq.html">
          <i class="bi bi-question-circle"></i>
          <span>F.A.Q</span>
        </a>
      </li><!-- End F.A.Q Page Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" href="pages-contact.html">
          <i class="bi bi-envelope"></i>
          <span>Contact</span>
        </a>
      </li><!-- End Contact Page Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" href="signup">
          <i class="bi bi-card-list"></i>
          <span>Register</span>
        </a>
      </li><!-- End Register Page Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" href="login">
          <i class="bi bi-box-arrow-in-right"></i>
          <span>Login</span>
        </a>
      </li><!-- End Login Page Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" href="pages-error-404.html">
          <i class="bi bi-dash-circle"></i>
          <span>Error 404</span>
        </a>
      </li><!-- End Error 404 Page Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" href="pages-blank.html">
          <i class="bi bi-file-earmark"></i>
          <span>Blank</span>
        </a>
      </li><!-- End Blank Page Nav -->

    </ul>

  </aside>