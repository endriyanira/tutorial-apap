import React from "react";
import Button from "../button";
import classes from "./styles.module.css";
import Search from "../../components/search";
import Form from "../../components/form";
// import ItemList from "../../containers/itemlist";

const Item = (props) => {
    const { id, title, price, description, category, quantity, stok, handleEdit, handleDelete,handleAddToCart,handleChangeField} = props;
    
    return (
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Harga: ${price}`}</p>
            <p>{`Deskripsi: ${description}`}</p>
            <p>{`Kategori: ${category}`}</p>
            <p>{`stok: ${quantity}`}</p>
            <Button action={handleEdit}>Edit</Button>
            <Button action={handleDelete}>Delete</Button>
            <div className="row p-10">
                <Form></Form>
            
            <Button action={handleAddToCart}>Add To Cart</Button>

            </div>
        </div>
    );
};
export default Item;