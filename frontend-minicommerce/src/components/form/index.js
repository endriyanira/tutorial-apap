import React from "react";
import Button from "../button";
import Search from "../../components/search";

const Form = (props) => {
    const { stok, handleChangeField} = props;
    return (
        <form>
            <input
                className="form-control"
                type="text"
                placeholder="Masukan Stok Item Ke Cart"
                name="stok"
                value={stok}
                onChange={handleChangeField}
            />
        </form>
    )
}
export default Form;