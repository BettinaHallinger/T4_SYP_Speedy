<script>
    import { Routerer, Link, Route } from "svelte-navigator";
    export let loginRoute;
    import sjcl from 'sjcl'

    let username = "";
    let password = "";
    let passwordHash = "";
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


    function setSessionUser() {
        sessionStorage.setItem("userName", email);
        console.log(window.sessionStorage.getItem("userName"));

        sessionStorage.setItem("userPass", passwordHash);
        console.log(window.sessionStorage.getItem("userPass"));
    }

    async function submitUser() {
        const data = {
            userName: sessionStorage.getItem("userName"),
            userPass: sessionStorage.getItem("userPass")
        };

        const response = await fetch("/submit-user", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(data),
        });

        if (response.ok) {
            const result = await response.text();
            // Handle the returned message from Java
            console.log(result);
        } else {
            // Handle the error case
            console.error('Error occurred during request');
        }
    }

    function hashPassword() {

        const userPass = password;
        const myBitArray = sjcl.hash.sha256.hash(userPass);
        const passHash = sjcl.codec.hex.fromBits(myBitArray);
        console.log(passHash);
        passwordHash = passHash;
    }

    function handleSubmission() {
    hasBeenClicked = true;
        if (email !== "" && isValidPassword) {
            // Send data somewhere
            hashPassword();
            setSessionUser();
            alert("submitted");
            submitUser();
        }
    }

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