<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>build</title>
    <base href="/">

    <!-- Stylesheets -->
	<link id="powatag-css" rel="stylesheet" href="http://assets.powatag.com/qr/sandbox/nextRelease/css/powatag.css">
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css">
	<link rel="stylesheet" href="/assets/css/bootstrap-flaty.css"/>
	<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/css/sticky-footer-navbar.css"/>
	<link rel="stylesheet" href="/assets/css/main.css"/>
	
</head>
	<body ng-controller="MainController as main">
		<#include "./common/nav_bar.ftl"/>

		<div class="container-fluid">
			<#if sectionTemplatePath??>
				<#include sectionTemplatePath>
			</#if>
		</div>
		<script data-main="${scriptPath}" src="/assets/js/lib/require.js"></script>
	</body>
</html>
