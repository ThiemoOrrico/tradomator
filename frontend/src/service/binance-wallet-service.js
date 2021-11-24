import axios from "axios";

export const getWallet = () => {
    return axios
        .get('/api/wallet')
        .then(res => res.data)


}