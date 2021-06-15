<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" >
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/ads">Post Lister</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <form action="/search">
        <input type="text" name="term" placeholder="Search term">
        <button class="btn">Search</button>
    </form>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/posts/show">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/posts/create">Create</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/posts/edit">Edit</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Logout</a>
                </li>
            </ul>
            <span class="navbar-text">
        Navbar text with an inline element
      </span>
        </div>
    </div>
</nav>
</body>
</html>