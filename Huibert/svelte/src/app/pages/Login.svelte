<script>
    import { Routerer, Link, Route } from "svelte-navigator";
    export let loginRoute;

    let username = "";
    let password = "";
    let hasBeenClicked = false;

    /**
    * @param {string} username
    */
    
    function validateUsername(username) {
      //  var emailRegEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;  
      //  return emailRegEx.test(String(email).toLowerCase());
      if(username != ''){
         return username;
      }
    }
    
    
    function handleSubmission() {
        hasBeenClicked = true;
        if (isValidUsername && isValidPassword) {
            // Send data somewhere
            alert("submitted");
        }
    }

    $: isValidUsername = validateUsername(username);
    $: isValidPassword = password.length >= 4;
    
</script>


    <div class = "textField">
        <h1>Login</h1>
        <div class="input-wrapper">
            <input class="eingabe" type="text" bind:value={username} placeholder="Username"/>
            {#if hasBeenClicked && !isValidUsername}
                <p class="validation-error">Invalid Username</p>
            {/if}
                {#if isValidUsername}
            <p class="validation">Valid Username</p>
            {/if}
        </div>
        
        <div class="input-wrapper">
            <input class="eingabe" type="password" bind:value={password} placeholder="Password"/>
                
            {#if hasBeenClicked && !isValidPassword}
            <p class="validation-error">Please enter a longer password</p>
                {/if}
            {#if isValidPassword}
            <p class="validation">Password is save.</p>
            {/if}
        </div>

        <!--<button class="btnSubmit" on:click={handleSubmission} >Login</button>-->

        {#if isValidUsername && isValidPassword}
           <button class="btnSubmit"><Link to="/settings" >Login</Link></button>
        {/if}

    </div>

<style>
    :global(button) {
        padding: 0.6em 3em 0.6em 3em;
        border: none;
        margin: 1%;
        font-size: 18px;
        cursor: pointer;
        border-radius: 25px;
    }

    .textField{
        width: 100%;
        padding-left: 10px;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;

    }

    .input-wrapper {
        flex: 1;
        text-align: left;
        padding-bottom: 20px;
    }

    .validation-error {
        color: rgb(176, 30, 30);
        margin-top: 5px;
    }

    .validation{
        color: green;
        margin-top: 5px;
    }

    h1 {
        text-align: center;
    }

    .btnSubmit{
        transition: 0.2s ease-in-out;
        background-color: #0e80c8;
        color: white;
        margin-top: 5%;
        margin-bottom: 10%;

    }

    .btnSubmit:hover{
        background-color: #1f1f1f;
    }

    .btnSubmit:focus{
        outline: none;
        background-color: #1f1f1f;
    }

</style>