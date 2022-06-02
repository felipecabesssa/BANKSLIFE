<template>
  <div class="main">
      <div v-if="previewImage" class="preview">
          <img :src="previewImage" alt="Imagem">
      </div>
      <input type="file" @change="selectImage">

      <div
        v-if="progress > 0"
        class="progress-bar progress-bar-info mt-4"
        role="progressbar"
        :aria-valuenow="progress"
        aria-valuemin="0"
        aria-valuemax="100"
        :style="{ width: progress + '%' }"
        >{{ progress }}%
      </div>

      <button class="btn btn-warning mt-4" @click="uploadImage">Upload</button>
  </div>
</template>

<script>
import axios from 'axios'
export default {

    data(){
        return{
            previewImage:null,
            selectedImage:null,
            id: this.$route.params.id,
            progress:0
        }
    },

    methods:{
        selectImage(e){
            console.log(e.target.files[0])
            this.selectedImage = e.target.files[0]
            this.previewImage = URL.createObjectURL(this.selectedImage)
        },

        uploadImage(){
            let formData = new FormData()
            formData.append('file', this.selectedImage)
            var token = localStorage.getItem('token')
            const headers = { Authorization: `Bearer ${token}` }
            axios.post('http://localhost:8081/fotos/' + this.id, formData,
             {
                  headers,
                  onUploadProgress: (event) => {this.progress = Math.round((100 * event.loaded) / event.total)}
             }
             ).then(resp => {
                console.log(resp.data)
            })
        }
    }

}
</script>

<style lang="scss" scoped>

.main{
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 1%;
    .preview{
        padding: 1%;
        max-width: 35%;
        img{
            max-width: 90%;
        }
    }
}

</style>