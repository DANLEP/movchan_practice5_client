<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title} Place</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-4">
    <h2>${title} Place</h2>

    <form action="/${action}" method="post">

        <!-- Title -->
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" id="title" name="title" required minlength="3" maxlength="100" value="${editedPlace.title}">
        </div>

        <!-- Description -->
        <div class="form-group">
            <label for="description">Description</label>
            <textarea class="form-control" id="description" name="description" required minlength="10" maxlength="1000"
                      rows="3">${editedPlace.description}</textarea>
        </div>

        <!-- Activity -->
        <div class="form-group">
            <label for="title">Activity</label>
            <input type="text" class="form-control" id="activity" name="activity" required minlength="3" maxlength="10" value="${editedPlace.type}">
        </div>

        <!-- Street -->
        <div class="form-group">
            <label for="street">Street</label>
            <input type="text" class="form-control" id="street" name="street" required minlength="1" maxlength="100"
                   value="${editedPlace.address.street}">
        </div>

        <!-- House Number with Letter -->
        <div class="form-group">
            <label for="houseNumber">House Number</label>
            <input type="text" class="form-control" id="houseNumber" name="houseNumber" required minlength="2"
                   maxlength="10" value="${editedPlace.address.houseNumber.numberWithLetter}">
        </div>

        <!-- City -->
        <div class="form-group">
            <label for="city">City</label>
            <input type="text" class="form-control" id="city" name="city" required minlength="1" maxlength="50"
                   value="${editedPlace.address.city}">
        </div>

        <!-- Postal Code -->
        <div class="form-group">
            <label for="postalCode">Postal Code</label>
            <input type="number" class="form-control" id="postalCode" name="postalCode" required minlength="4"
                   maxlength="6" value="${editedPlace.address.postalCode}">
        </div>

        <!-- Latitude -->
        <div class="form-group">
            <label for="latitude">Latitude</label>
            <input type="number" class="form-control" id="latitude" name="latitude" required min="-90.0" max="90.0"
                   step="0.0001" value="${editedPlace.coordinate.latitude}">
        </div>

        <!-- Longitude -->
        <div class="form-group">
            <label for="longitude">Longitude</label>
            <input type="number" class="form-control" id="longitude" name="longitude" required min="-180.0" max="180.0"
                   step="0.0001" value="${editedPlace.coordinate.longitude}">
        </div>

        <!-- Working Hours -->
        <div class="form-group">
            <!-- Working Hours -->
            <div class="form-group">
                <label for="openingTime">Opening Time</label>
                <input type="time" class="form-control" id="openingTime" name="openingTime" value="${openingTime}">
            </div>
            <div class="form-group">
                <label for="closingTime">Closing Time</label>
                <input type="time" class="form-control" id="closingTime" name="closingTime" value="${closingTime}">
            </div>
        </div>

        <div class="form-group">
            <label for="season">Season</label>
            <select class="form-control" id="season" name="season">
                <c:forEach items="${seasons}" var="season">
                    <option value="${season}" ${season == editedPlace.seasonality ? 'selected="selected"' : ''}>${season}</option>
                </c:forEach>
            </select>
        </div>

        <!-- Recommended Checkbox -->
        <div class="form-check">
            <input type="checkbox" class="form-check-input" id="isRecommended" name="isRecommended"
            ${editedPlace.isRecommended ? 'checked' : ''}>
            <label class="form-check-label" for="isRecommended">Is Recommended</label>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
