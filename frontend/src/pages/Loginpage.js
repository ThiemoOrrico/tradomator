import React, {useContext, useState} from 'react';
import {AuthContext} from "../context/AuthProvider";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";

const initialState = {
    username: "",
    password: ""
}

export default function Loginpage() {

    const [credentials, setCrededtials] = useState(initialState);
    const {login} = useContext(AuthContext)

    const handleChange = event => {
        setCrededtials({...credentials, [event.target.name] : event.target.value})
    }

    const handleSubmit = event => {
        event.preventDefault()
        login(credentials)
    }

    return (
        <form onSubmit={handleSubmit}>
        <Box
            sx={{
                '& > :not(style)': { m: 1, width: '25ch' },
            }}
            autoComplete="off"
        >
            <TextField
                id="outlined-name"
                name="username"
                label="Userame"
                value={credentials.username}
                required={true}
                onChange={handleChange}
            />

            <TextField
                id="outlined-password"
                name="password"
                type={"password"}
                label="Password"
                value={credentials.password}
                required={true}
                onChange={handleChange}
            />

            <Button type="submit" onClick={handleSubmit} variant= "outlined">Login</Button>
        </Box>
        </form>
    )
};

