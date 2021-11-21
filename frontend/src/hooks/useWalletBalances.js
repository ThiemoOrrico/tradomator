import {useEffect, useState} from "react";
import {getWallet} from "../service/binance-wallet-service";


export default  function useWalletBalances(token){
    const [wallet, setWallet] = useState({})

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
