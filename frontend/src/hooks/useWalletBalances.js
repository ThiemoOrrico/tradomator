import {useContext, useEffect, useState} from "react";
import {getWallet} from "../service/binance-wallet-service";
import {AuthContext} from "../context/AuthProvider";


export default  function useWalletBalances(){
    const [wallet, setWallet] = useState({})
    const { token } = useContext(AuthContext)

    const getWalletBalances = () =>{
        getWallet(token)
            .then(setWallet)
            .catch(console.error)
    }

    useEffect( () => {
        getWalletBalances(token)
    }, [token])



    return { wallet,setWallet, getWalletBalances}
}
