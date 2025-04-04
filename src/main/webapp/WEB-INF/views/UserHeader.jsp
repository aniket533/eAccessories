<div class="container-fluid fixed-top" style="top: 0px;">
            <div class="container topbar bg-primary d-none d-lg-block">
                <div class="d-flex justify-content-between">
                    <div class="top-info ps-2">
                        <small class="me-3"><i class="fas fa-map-marker-alt me-2 text-secondary"></i> <a href="#" class="text-white">Navarangpura, Ahmedabad</a></small>
                        <small class="me-3"><i class="fas fa-envelope me-2 text-secondary"></i><a href="#" class="text-white">kk4766670@gmail.com</a></small>
                    </div>
                    <div class="top-link pe-2">
                        <a href="#" class="text-white"><small class="text-white mx-2">Privacy Policy</small>/</a>
                        <a href="#" class="text-white"><small class="text-white mx-2">Terms of Use</small>/</a>
                        <a href="#" class="text-white"><small class="text-white ms-2">Sales and Refunds</small></a>
                    </div>
                </div>
            </div>
            <div class="container px-0">
                <nav class="navbar navbar-light bg-white navbar-expand-xl">
                    <a href="userhome" class="navbar-brand"><h1 class="text-primary display-6">Gadgets Marketplace</h1></a>
                    <button class="navbar-toggler py-2 px-3" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                        <span class="fa fa-bars text-primary"></span>
                    </button>
                    <div class="collapse navbar-collapse bg-white" id="navbarCollapse">
                        <div class="navbar-nav mx-auto">
                            <a href="userhome" class="nav-item nav-link active">Home</a>
                            <a href="userhome#accessoriesshop" class="nav-item nav-link">Shop</a>
                            <a href="shop-detail.html" class="nav-item nav-link">Shop Detail</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                                <div class="dropdown-menu m-0 bg-secondary rounded-0">
                                    <a href="cart.html" class="dropdown-item">Cart</a>
                                    <a href="chackout.html" class="dropdown-item">Chackout</a>
                                    <a href="testimonial.html" class="dropdown-item">Testimonial</a>
                                    <a href="404.html" class="dropdown-item">404 Page</a>
                                </div>
                            </div>
                            <a href="contact" class="nav-item nav-link">Contact</a>
                        </div>
                        <div class="d-flex m-3 me-0">
                            <button class="btn-search btn border border-secondary btn-md-square rounded-circle bg-white me-4" data-bs-toggle="modal" data-bs-target="#searchModal"><i class="fas fa-search text-primary"></i></button>
                            <a href="#" class="position-relative me-4 my-auto">
                                <i class="fa fa-shopping-bag fa-2x"></i>
                                <span class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1" style="top: -5px; left: 15px; height: 20px; min-width: 20px;">3</span>
                            </a>
                            
                         	<!-- <a href="#" class="my-auto"> 
                         		<i class="fas fa-user fa-2x"></i>
                            </a> 
                             -->
                             
                             <!-- Profile Component -->
					<div class="nav-item dropdown">
						<a class="nav-link nav-profile d-flex align-items-center" href="#"
							data-bs-toggle="dropdown"> <img src="${user.profilePicPath}"
							alt="Profile" class="rounded-circle"
							style="width: 40px; height: 40px;"> <span
							class="d-none d-md-block dropdown-toggle ps-2">${user.firstName}</span>
						</a>
						<!-- Profile Dropdown Menu -->

						<ul
							class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
							<li class="dropdown-header">
								<h6>${user.firstName}</h6> <span>${user.role}</span>
							</li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item d-flex align-items-center"
								href="profile"> <i class="bi bi-person"></i> <span>My
										Profile</span></a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item d-flex align-items-center"
								href="profile"> <i class="bi bi-gear"></i> <span>Account
										Settings</span></a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item d-flex align-items-center"
								href="contact"> <i class="bi bi-question-circle"></i> <span>Need
										Help?</span></a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item d-flex align-items-center"
								href="logout"> <i class="bi bi-box-arrow-right"></i> <span>Sign
										Out</span></a></li>
						</ul>
					</div>
					<!-- End Profile Component -->       
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        
        
        <!-- modal start -->
       	<div class="modal fade" id="searchModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-fullscreen">
                <div class="modal-content rounded-0">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Search by keyword</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body d-flex align-items-center">
                        <div class="input-group w-75 mx-auto d-flex">
                            <input type="search" class="form-control p-3" placeholder="keywords" aria-describedby="search-icon-1">
                            <span id="search-icon-1" class="input-group-text p-3"><i class="fa fa-search"></i></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
         <!-- modal end -->