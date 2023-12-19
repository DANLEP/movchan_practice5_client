<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Places</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/places">Places Directory</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto mr-4">
            <li class="nav-item">
                <a class="nav-link btn btn-primary text-white" href="/add">Додати місце</a>
            </li>
        </ul>
        <form class="form-inline" action="/activity" method="get">
            <input class="form-control mr-sm-2" type="search" placeholder="Пошук за активністю" aria-label="Search" name="activity">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Пошук</button>
        </form>
    </div>
</nav>

<div class="container mt-4">
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger" role="alert">
            <h4 class="alert-heading">Oops!</h4>
            <p>${errorMessage}</p>
        </div>
    </c:if>
    <c:if test="${not empty successfulMessage}">
        <div class="alert alert-success" role="alert">
            <h4 class="alert-heading">Well done!</h4>
            <p>${successfulMessage}</p>
        </div>
    </c:if>
    <c:if test="${empty places}">
        <div class="d-flex justify-content-center align-items-center" style="height: 200px; color: gray;">Місць немає!</div>
    </c:if>
    <br>
    <c:forEach var="place" items="${places}">
        <div class="card mb-3">
            <div class="card-body">
                <h5 class="card-title">${place.title}</h5>
                <h6 class="card-subtitle mb-2 text-muted">${place.type}</h6>
                <p class="card-text">${place.description}</p>
                <p class="card-text"><small class="text-muted">
                    Address: ${place.address.street} ${place.address.houseNumber.number}${place.address.houseNumber.numberWithLetter}, ${place.address.city}, ${place.address.postalCode}
                </small></p>
                <p class="card-text"><small class="text-muted">
                    Coordinates: Latitude ${place.coordinate.latitude}, Longitude ${place.coordinate.longitude}
                </small></p>
                <p class="card-text"><small class="text-muted">
                    Visit Time: ${place.visitTime}
                </small></p>
                <p class="card-text"><small class="text-muted">
                    Seasonality: ${place.seasonality}
                    <c:if test="${place.isRecommended}">
                        | Recommended
                    </c:if>
                </small></p>
                <c:if test="${place.rating}">
                    <p class="card-text"><small class="text-muted">
                        Rating: ${place.rating}
                    </small></p>
                </c:if>
                <div class="d-flex justify-content-start align-items-center mt-2">
                    <a href="/edit/${place.id}" class="btn btn-warning mr-2">Редагувати</a>
                    <form action="/delete/${place.id}" method="post">
                        <button class="card-link btn btn-danger" type="submit"
                                onclick="return confirm('Are you sure you want to delete this dish?')">Видалити
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>