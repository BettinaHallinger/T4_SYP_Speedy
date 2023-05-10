<script>
	import {
		onclickMG,
		onclickLED,
		onclickDisText,
		onclickUmschG,
		onclickWlanM
	} from '../app/routing/Router.svelte';
	import Router from '../app/routing/Router.svelte';

	let routeChange = 'Home';
</script>

<!--<div class="containerAll">-->
	<div class="header">
		<div class="blue"></div>
		<div class="gray">
			<img src="HTL-Logo.png"> 
		</div>
	</div>
	<!-- TODO: Take the 'routeChange' variable from +page.svelte and use it in a switch-case (in 'Router.svelte') to not use a function for every single button -->

	<div class="containerBoth">
		<div class="container">
			<!--<ul2 class="conButton">-->
				<button class="btn" on:click={onclickMG} on:click={() => (routeChange = 'MG')}>Motor</button>
				<button class="btn" on:click={onclickLED} on:click={() => (routeChange = 'LED')}>LED</button>
				<button class="btn"on:click={onclickDisText} on:click={() => (routeChange = 'DT')}>Display</button>
				<!-- <button class="btn" on:click={onclickUmschG} on:click={() => (routeChange = 'UG')}>Umschaltgeschwindigkeit</button> -->
				<button class="btn" on:click={onclickWlanM} on:click={() => (routeChange = 'WM')}>WLAN-Modus</button>
				<button class="btnSubmit">Submit</button>
			<!-- </ul2> -->
		</div>
		<!-- <p>Visit <a href="https://kit.svelte.dev">kit.svelte.dev</a> to read the documentation</p> -->
		<div class="container2">
			{#key routeChange}
				<Router />
			{/key}
		</div>
	</div>
<!--</div>-->

<!--
<MotorG/>
<Home/>
-->

<!-- Click()-> Funktion erstellen, damit die Button Funktion funktioniert. Wenn auf Button geklickt wird sollte Nested.svelte geöffnet werden. -->
<!-- npm run dev (Terminal) -->

<!-- <h1>Welcome to SvelteKit</h1>
<p>Visit <a href="https://kit.svelte.dev">kit.svelte.dev</a> to read the documentation</p> -->
<style>
	:global(body) {
		background-color: #2e2e2e;
		padding: 0;
		margin: 0;
		padding-top: 90px;
		overflow-x: hidden; 
		font-family: calibri light, arial;
	}

	h1 {
		color: white;
		text-align: center;
		font-size: 37px;
		margin-bottom: 5%;
	}

	:global(button){
		padding: 0.6em;
		border: none;
		margin: 1%;
		font-size: 18px;
		cursor: pointer;
		border-radius: 25px;
	}

	:global(.btn) {
		color: #fff;
		background-color: #161616;
	}

	:global(.btn:hover) {
		transition: 0.2s ease-in-out;
		background-color: #0e80c8;
		color: white;
	}

	:global(.btn:focus){
      outline: none;
      background-color: #0e80c8;
    }


	:global(.btnSubmit) {
		transition: 0.2s ease-in-out;
		background-color: #0e80c8;
		color: white;
		margin-top: 5%;
	}

	:global(.btnSubmit:hover) {
		background-color: #1f1f1f;
	}

	:global(.btnSubmit:focus){
      outline: none;
      background-color: #1f1f1f;
    }

	.header{
		width: 100%;
		position: fixed;
		top: 0;
		z-index: 1;
	}

	.blue {
		list-style-type: none;
		margin: 0;
		padding: 0;
		border: 1px solid #0e80c8;
		background-color: #0e80c8;
		width: 100%;
		padding: 1px 50%;
		height: 4px
	}

	.gray {
		display: flex;
		align-items: center;
		justify-content: start;
		list-style-type: none;
		margin: 0;
		padding: 0;
		overflow: hidden;
		border: 1px solid #4e4e4e;
		background-color: #4e4e4e;
		width: 100%;
		 
	}

	img{
		margin-left: 20px;
		width: 200px;
		
	}

	:global(.eingabe){
    padding: 0.7em;
    width: 100%;
    margin-bottom: 1em;
    border: none;
    border-radius: 10px;
    transition: 0.1s ease-in-out;
	}

	:global(.eingabe:focus)	{
		outline: 2px solid #0e80c8;
	}

	.containerBoth {
		overflow: hidden;
		display: grid;
		grid: 1fr / 30% 1fr;
		width: 100%;
	}

	.container {

		justify-content: start;
		margin-top: 2em;
		display: flex;
		flex-direction: column;
		padding: 2em;
		width: 100%;
		position: sticky;
		top: 0;	
	}

	.container2 {
		width: 100%;
		display: flex;
		justify-content: center;
		align-items: center;
		float: right;
		justify-self: center;
		height: 100%;
		padding-top: 3em;	
	}

	@media (max-width: 780px){
		ul{
			position: sticky; 
			top: 0;
		}


		.container{
			width: 90%;
			position: relative;
			grid-column: 1 / -1;
		}

		.container2{
			width: 100%;
			padding-bottom: 4em;
			grid-column: 1 / -1;
			padding-top: 1em;
		}
	}

</style>
