import { useEffect, useState } from "react"
import './App.css'

const END_POINT_FILM = 'http://localhost:4000/film/';

export function App(){

    const [endpoint, setEndpoint] = useState(END_POINT_FILM);

    const [data, Setdata] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    useEffect(() => {
        setLoading(true);
        fetch(endpoint)
        .then(res => res.json())
        .then(data => Setdata(data))
        .catch(error => setError("Error al obtener los datos"))
        .finally(() => setLoading(false));
    },[endpoint]);

    return(
        <main>
            <section className="title">
                <h1>Star War Films</h1>
            </section>
            <section className="finder">
                <form>
                    <div className="form-div">
                        <label>
                            <input
                                type="checkbox"
                                name="option"
                                value="title"
                            />
                            Title
                        </label> 
                        <input 
                            type="text" 
                            id="textInputTitle" 
                            placeholder="Title"
                        />                   
                    </div>
                    
                    <button>Search</button>  
                </form>  
            </section> 
            <section className="result">
                {
                    loading && 
                    <h1>Loading...</h1>
                }
                
                { !loading && data  &&<table>
                    <thead>
                         <tr>
                            <th>imdbID</th>
                            <th>title</th>
                            <th>year</th>
                            <th>plot</th>
                        </tr>
                    </thead>
                    <tbody>
                        {data.map((item, index) => (
                        <tr key={index}>
                            <td>{item.imdbID}</td>
                            <td>{item.title}</td>
                            <td>{item.year}</td>
                            <td>{item.plot}</td>
                        </tr>
                        ))}
                    </tbody> 
                </table>
                }
            </section>
        </main>

    )
}