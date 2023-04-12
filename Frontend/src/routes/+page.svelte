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

<div class="containerAll">
	<ul1 />
	<ul>
		<img src="HTL-Logo.png"> 
	</ul>

	<h1>Welcome to Speedy</h1>
	<!-- TODO: Take the 'routeChange' variable from +page.svelte and use it in a switch-case (in 'Router.svelte') to not use a function for every single button -->

	<div class="containerBoth">
		<div class="container">
			<!--<ul2 class="conButton">-->
				<button on:click={onclickMG} on:click={() => (routeChange = 'MG')}
					>Motorgeschwindigkeit</button>
				<button on:click={onclickLED} on:click={() => (routeChange = 'LED')}>LED</button>
				<button on:click={onclickDisText} on:click={() => (routeChange = 'DT')}>Displaytext</button>
				<button on:click={onclickUmschG} on:click={() => (routeChange = 'UG')}
					>Umschaltgeschwindigkeit</button
				>
				<button on:click={onclickWlanM} on:click={() => (routeChange = 'WM')}>WLAN-Modus</button>
				<button class="buttnSumbmit">Submit</button>
			<!-- </ul2> -->
		</div>
		<!-- <p>Visit <a href="https://kit.svelte.dev">kit.svelte.dev</a> to read the documentation</p> -->
		<div class="container2">
			{#key routeChange}
				<Router />
			{/key}
		</div>
	</div>
</div>

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
		overflow-x: hidden;

	}

	h1 {
		color: white;
		text-align: center;
		font-size: 37px;
		margin-bottom: 5%;
	}

	button {
		border: 10px solid transparent;
		color: #fff;
		background-color: #000000;
		border-radius: 15px;
		/*width: 20em;*/
		/*display: inline-block;*/
		margin: 1%;
		/*display: block;
		flex-direction: column;*/
		font-size: 18px;
	}

	button:hover {
		background-color: #0e80c8;
		color: white;
	}

	.buttnSumbmit {
		background-color: #0e80c8;
		margin-top: 5%;
	}

	.buttnSumbmit:hover {
		background-color: #1f1f1f;
	}

	ul {
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
		height: 90px;
		position: sticky;
		top: 0;
	}

	img{
		margin-left: 20px;
		width: 200px;
		
	}
	li {
		display: block;
		color: #fff;
		padding: 17px 20px;
	}

	ul1 {
		list-style-type: none;
		margin: 0;
		padding: 0;
		overflow: hidden;
		border: 1px solid #0e80c8;
		background-color: #0e80c8;
		width: 100%;
		padding: 1px 50%;
	}

	nav {
		flex-basis: 10rem;
		/* background-color: yellow; */
		padding: 1rem;
	}

	.containerBoth {
		/* display: flex;
		justify-content: center;
		 grid-template-columns: repeat(8, 1fr); 
		height: fit-content;
		align-items: start;*/
		/*grid-auto-rows: 1fr;
		grid-gap: 0.5em;
		
		grid-auto-flow: column; */
	}

	.container {
		/*
		grid-column: 1 / 3;
		grid-row: 1 / -1;
		display: grid;*/
		/* display: flex; */
		justify-content: center;
		/* background-color: aqua;
		height: max-content;
		margin: 1em; */
		width: 30%;
		/* margin: 1em; */
		display: flex;
		flex-direction: column;
		padding: 2em;
		/* height: screen; */
		position: fixed;
		float: left;
		
		
	}

	.container2 {
		/*background-color: rgb(26, 200, 142);
		grid-column: 3 / 9;
		
		grid-row: 1 / -1;
		display: grid;*/
		width: 65%;
		display: flex;
		justify-content: center;
		align-items: center;
		float: right;
		/* height:	max-content; */
		background-color: grey;
		
	}

	@media (max-width: 780px){
		ul{
			position: sticky; 
			top: 0;
		}

		.containerBoth{
			flex-wrap: wrap;
			flex-direction: column;
		}

		.container{
			width: 90%;
			position: relative;
		}

		.container2{
			width: 100%;
			padding-bottom: 4em;
		}
	}

</style>
