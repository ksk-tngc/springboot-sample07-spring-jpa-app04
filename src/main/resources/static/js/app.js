'use strict'

{
  /**
   * 商品IDの削除ボタン
   */
  $('#productIdDelBtn').on('click', function () {
    // 必須チェック
    if ($('#deletionProductId').val() === '') {
      alert('商品IDを入力してください')
      $('#deletionProductId').focus()
      return false
    }
  })

  /**
   * 商品名の削除ボタン
   */
  $('#productNameDelBtn').on('click', function () {
    // 空白除去
    $('#deletionProductName').val($('#deletionProductName').val().trim())

    // 必須チェック
    if ($('#deletionProductName').val() === '') {
      alert('商品名を入力してください')
      $('#deletionProductName').focus()
      return false
    }
  })
}
